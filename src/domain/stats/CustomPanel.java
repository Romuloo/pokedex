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

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Javier Linares Castrillon
 */

/**
 * Esta clase está obsoleta.
 * Ha sido reemplazada por PanelMapa.
 */
public class CustomPanel extends JPanel{
    //Image image = new ImageIcon("kanto.jpg").getImage();

    @Override
    public void paint(Graphics g){
       // g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        //g.setOpaque(false);
        super.paint(g);
    }
}