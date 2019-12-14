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
package app.before;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Javier Linares Castrillon
 * @author Andrés Iturria Soler
 *
 */


public class PokedexFondo extends JPanel {

    public PokedexFondo() {
        this.setSize(1600/4, 2846/4);

    }

    /**
     * Pinta el fondo del panel.
     * @param g
     */

    public void paint(Graphics g){


        ImageIcon Img = new ImageIcon("res/imagenes/pokedex.png");
        g.drawImage(Img.getImage(), 0, 0, 1600/4, 2846/4, null);


        setOpaque(false);
        super.paint(g);

    }


}