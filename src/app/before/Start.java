package app.before;
import DAO.Conexion;
import domain.localizacion.PanelMapa;
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
 *
 */

/**
 * Clase encargada de comenzar con el programa una vez seleccionado.
 */
public class Start {

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
            Logger.getLogger(app.Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
