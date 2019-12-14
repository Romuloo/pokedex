package app.before;
import domain.localizacion.PanelMapa;
import domain.pokemons.ListaPokemons;
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

    /**
     *
     * Método encargado de establecer conexión con la base de datos, inicializar el main Frame y correr el programa.
     */
    public static void start(){

        try {
            JTabbedPane jt = new JTabbedPane();
            PanelMapa p = new PanelMapa();
            ListaPokemons l = new ListaPokemons();
            JFrame f = new JFrame();
            Movimientos m = new Movimientos();


            jt.add(l);
            jt.add(m);
            jt.add(p);

            jt.setIconAt(2, ayuda);
            jt.setIconAt(1, ataques);
            jt.setIconAt(0, pokemons);




            f.add(jt);
            jt.setBackground(Color.black);
            f.setTitle("Pokedex");
            f.setSize(((1500/3)*2)+100,(1061/3)*2+50);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);
            f.setResizable(false);


        } catch (SQLException ex) {
            Logger.getLogger(app.Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
