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
import domain.localizacion.*;
import domain.movimientos.Movimientos;
import domain.stats.*;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Javier Linares Castrillon
 */
public class Main {
    public static void main(String[] args){

        Conexion.conectar();
        JTabbedPane jt = new JTabbedPane();
        PanelMapa p = new PanelMapa();
        JFrame f = new JFrame();
        Movimientos m = new Movimientos();
        jt.add(p, "Localizaciones");
        jt.add(m, "Movimientos");

        f.add(jt);
        jt.setBackground(Color.black);
        f.setTitle("Pokedex");
        f.setSize(((1500/3)*2)+100,(1061/3)*2+50);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setResizable(false);
         //Conexion.connect();
        //
    }
}
