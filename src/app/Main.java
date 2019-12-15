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

package app;
import DAO.Conexion;
import app.before.Begin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Javier Linares Castrillon
 * @author Andrés Iturria Soler
 * @author Samuel Aragonés Lozano
 *
 */

/**
 * Clase principal donde comienza el programa.
 */
public class Main {

    private static JFrame f = new JFrame("->");
    private static ImageIcon icon = new ImageIcon("res/imagenes/fotos/0.png");
    private static Icon pokemons = new ImageIcon(icon.getImage().getScaledInstance(512/10, 512/10, Image.SCALE_DEFAULT));
    private static JButton b = new JButton();

    /**
     *
     * Método Main desde donde se ejecuta la app.
     */
    public static void main(String[] args){
        initComponents();
    }

    private static void initComponents(){

        b.setIcon(pokemons);
        b.setOpaque(true);
        b.setContentAreaFilled(false);
        b.setBorderPainted(false);
        b.setBorder(null);

        f.add(b);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                Begin.init();

            }
        });
        f.setSize(512/10*2,512/10*2);
        f.setVisible(true);
        f.setResizable(false);
        f.setLocation(100,100);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBackground(new Color(180, 15, 15));
    }
}