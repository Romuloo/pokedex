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
import domain.localizacion.PanelMapa;
import domain.pokemons.ListaPokemons;
import domain.movimientos.Movimientos;

import javax.swing.*;
import java.awt.*;


/**
 *
 * @author Javier Linares Castrillon
 * @author Andrés Iturria Soler
 *
 */

/**
 * Clase encargada de comenzar con el programa una vez seleccionado.
 */
public class Start {



    private static ImageIcon aux = new ImageIcon("res/imagenes/localizaciones.png");
    private static Icon ayuda = new ImageIcon(aux.getImage().getScaledInstance(1000/100*5, 1200/100*5, Image.SCALE_DEFAULT));

    private static ImageIcon ing = new ImageIcon("res/imagenes/iconAtaque.png");
    private static Icon ataques = new ImageIcon(ing.getImage().getScaledInstance(512/10, 512/10, Image.SCALE_DEFAULT));

    private static ImageIcon icon = new ImageIcon("res/imagenes/fotos/0.png");
    private static Icon pokemons = new ImageIcon(icon.getImage().getScaledInstance(512/10, 512/10, Image.SCALE_DEFAULT));

    private static JTabbedPane jt = new JTabbedPane();
    private static PanelMapa p = new PanelMapa();
    private static ListaPokemons l = new ListaPokemons();
    private static JFrame f = new JFrame();
    private static Movimientos m = new Movimientos();


    public static Frame getFrame(){
        return f;
    }
    /**
     *
     * Método encargado de establecer conexión con la base de datos, inicializar el main Frame y correr el programa.
     */
    public static void start()  {

            jt.add(l);
            jt.add(m);
            jt.add(p);

            jt.setIconAt(2, ayuda);
            jt.setIconAt(1, ataques);
            jt.setIconAt(0, pokemons);



            f.add(jt);
            jt.setBackground(Color.black);
            f.setTitle("Pokedex");
            f.setBackground(new Color(39, 156, 207));
            f.setSize(((1500/3)*2)+100,(1061/3)*2+50);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);
            f.setResizable(false);

    }

}
