/**
 Copyright [2019] [Andres Iturria Soler, Javier Linares Castrillon, Samuel Aragones Lozano]
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at
 http://www.apache.org/licenses/LICENSE-2.0
 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.

 */
package domain.stats;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

/**
 *
 * @author Javier Linares Castrillon
 */
public class BarGraph {

    protected BarGraphModel model;
    protected BarGraphModel modelPhoto;

    protected static final Font BAR_TITLE_FONT = new Font("Calibri", Font.PLAIN,12);


    /**
     * Construye un Grafico de barras.
     * @param ps
     * @param ataque
     * @param defensa
     * @param ataqueEsp
     * @param defensaEsp
     * @param velocidad
     */

    public BarGraph(int ps, int ataque, int defensa, int ataqueEsp, int defensaEsp, int velocidad) {

        this.model = new BarGraphModel();
        this.modelPhoto = new BarGraphModel();

        modelPhoto.setLocation(20, 50);
        modelPhoto.setSize(440, 400);

        model.setLocation(20, 450);
        model.setSize(440, 300);

        BarGraphModel.BarItem item = new BarGraphModel.BarItem("Ps");
        item.percentage = regulator(ps);
        model.addItem(item);

        item = new BarGraphModel.BarItem("Ataque");
        item.percentage = regulator(ataque);
        model.addItem(item);

        item = new BarGraphModel.BarItem("Defensa");
        item.percentage = regulator(defensa);
        model.addItem(item);

        item = new BarGraphModel.BarItem("AtaqueEsp");
        item.percentage = regulator(ataqueEsp);
        model.addItem(item);

        item = new BarGraphModel.BarItem("DefensaEsp");
        item.percentage = regulator(defensaEsp);
        model.addItem(item);

        item = new BarGraphModel.BarItem("Velocidad");
        item.percentage = regulator(velocidad);
        model.addItem(item);


    }

    private int regulator(int stat){
        return stat * 100 / 700;
    }

    public BarGraphModel getModel() {
        return model;
    }
    public BarGraphModel getModelPhoto(){
        return modelPhoto;
    }



    public void draw(Graphics g) {
        drawItems(g);
        drawBoarder(g);
    }

    private void drawItems(Graphics g){
        int i = 0;
        g.setFont(BAR_TITLE_FONT);
        FontMetrics fm = g.getFontMetrics(BAR_TITLE_FONT);

        for (BarGraphModel.BarItem item : model.items){



            int percentHeight = ((int)((double)item.percentage/100 * model.getSize().height));

            int x = model.getX() + i * model.getHorizontalGap();
            int y = model.getY() + model.getSize().height - percentHeight;
            int w = item.width;
            int h = percentHeight;
            g.setColor(item.background == null ? new Color(255,130,51) : item.background);

            g.fillRect(x, y, w, h);
            i++;


            //Dibuja el titulo.


            int sw = fm.stringWidth(item.title);
            if (sw < item.width){
                x = x + ((item.width - sw)/2);
            } else {
                x = x - ((sw - item.width)/2);
            }

            y = model.getY() + model.getSize().height + BAR_TITLE_FONT.getSize();
            g.drawString(item.title, x, y);
        }
    }

    private void drawBoarder(Graphics g){
        g.setColor(Color.cyan);
        g.drawRoundRect(model.getX(), model.getY(), model.getSize().width, model.getSize().height, 5, 5);
        g.drawRoundRect(modelPhoto.getX(), modelPhoto.getY(),modelPhoto.getSize().width,modelPhoto.getSize().height,5,5);
    }


}
