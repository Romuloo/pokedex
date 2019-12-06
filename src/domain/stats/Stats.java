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


import DAO.Conexion;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Javier Linares Castrillon
 * @author Andrés Iturria Soler
 *
 */

/**
 * Clase encargada de generar un frame con las Stats del Pokemon consultado.
 */
public class Stats extends JPanel {

    private BarGraph graph;
    private BarGraphModel model;
    private static String thisPath;



    private ImageIcon image = new ImageIcon(thisPath);
    private Font f = new Font("Calibri", Font.BOLD, 26);

    private static String thisname;
    private static JFrame frame;

    private String path;
    private String nombre;
    private int ps;
    private int ataque;
    private int defensa;
    private int ataqueEsp;
    private int defensaEsp;
    private int velocidad;

    /**
     * Constructor de la clase Stats.
     *
     * @param path
     * @param nombre
     * @param ps
     * @param ataque
     * @param defensa
     * @param ataqueEsp
     * @param defensaEsp
     * @param velocidad
     */
    public Stats(String path, String nombre, int ps, int ataque, int defensa, int ataqueEsp, int defensaEsp, int velocidad ){

        this.path = path;
        this.nombre = nombre;
        this.ps = ps;
        this.ataque = ataque;
        this.defensa = defensa;
        this.ataqueEsp = ataqueEsp;
        this.defensaEsp = defensaEsp;
        this.velocidad = velocidad;

        setBackground(new Color(27, 29, 77));
        this.graph = new BarGraph(ps,ataque,defensa,ataqueEsp,defensaEsp,velocidad);
        this.model = graph.getModel();
    }


    /**
     * Dibuja el nombre, la imagen y el gráfico del Pokemon.
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        graph.draw(g);
        g.drawImage(image.getImage(),40 ,50,400,400,null);
        g.setFont(f);
        g.drawString("Stats de " + thisname, 110, 30);

    }

    //En vez de Singleton puesto que cada Frame tiene unas caracteristicas especiales.
    //Con Singleton llegaba a unos bugs muy graciosos. Se creaba un frame con los datos anteriores.

    private synchronized static void frameManager(){
        if(frame == null) frame = new JFrame();
        else if(frame != null) frameManagerAux();
    }
    private synchronized static void frameManagerAux(){
        frame.dispose();
        frame = new JFrame();

    }


    /**
     * Crea un frame para la clase Stats con los datos de un Pokemon de nombre n.
     * @param n
     */
    public static void start(String n) {


        Pokemon p = Conexion.pokemonStats(n);

        frameManager();
        frame.setLocationRelativeTo(null);
        frame.setLocation(1000,1000);
        frame.setTitle("Stats de " + p.getName());
        thisPath = p.getPath();
        thisname = p.getName();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(480, 840);
        frame.add(new Stats(p.getPath(), p.getName(), p.getPs(), p.getAt(), p.getDef(), p.getAte(), p.getDefe(), p.getVel()));
        frame.setVisible(true);
        frame.setResizable(false);

    }
}
