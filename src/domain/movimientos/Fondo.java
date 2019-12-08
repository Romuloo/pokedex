
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
package domain.movimientos;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Javier Linares Castrillon
 * @author Andrés Iturria Soler
 *
 */

/**
 * Clase encargada de generar un panel customizado con una imagen de fondo.
 */
public class Fondo extends JPanel {

    public Fondo() {
        this.setSize((1500/3)*2, (1061/3)*2);

    }

    public void paint(Graphics grafico) {
        Dimension height = getSize();
        ImageIcon Img = new ImageIcon("res/imagenes/esteFondo.png");
        grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);

        ImageIcon movs = new ImageIcon("res/imagenes/movs.png");
        grafico.drawImage(movs.getImage(), (1061/3)-50-60, 40-10, 400,90, null);

        ImageIcon Imge = new ImageIcon("res/imagenes/rotom.png");
        grafico.drawImage(Imge.getImage(), 650, 370, 1254 / 4, 1254 / 4, null);

        setOpaque(false);
        super.paint(grafico);


    }


}

