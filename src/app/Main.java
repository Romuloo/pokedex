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
import domain.mainPage.ListaPokemons;
import domain.movimientos.Movimientos;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javier Linares Castrillon
 * @author Andrés Iturria Soler
 * @author Samuel Aragonés Lozano
 *
 */

/**
 * Clase principal donde se inicializa el main Frame y se ejecuta el programa.
 */
public class Main {

    /**
     *
     * Método Main desde donde se ejecuta la app.
     */
    public static void main(String[] args){

        try {
            Conexion.conectar();
            JTabbedPane jt = new JTabbedPane();
            PanelMapa p = new PanelMapa();
            ListaPokemons l = new ListaPokemons();
            JFrame f = new JFrame();
            Movimientos m = new Movimientos();


            jt.add(l, "Pokemons");
            jt.add(m, "Movimientos");
            jt.add(p, "Localizaciones");


            f.add(jt);
            jt.setBackground(Color.black);
            f.setTitle("Pokedex");
            f.setSize(((1500/3)*2)+100,(1061/3)*2+50);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);
            f.setResizable(false);

        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
