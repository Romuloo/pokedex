package domain.stats;

import app.Main;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
/**
 *
 * @author Javier Linares Castrillon
 */
public class Stats extends JPanel {

    private BarGraph graph;
    private BarGraphModel model;
    private static String thisPath;

    private static JFrame frame;

    private ImageIcon image = new ImageIcon(thisPath);
    private Font f = new Font("Calibri", Font.BOLD, 26);
    private static String thisname;

    public Stats(int ps, int ataque, int defensa, int ataqueEsp, int defensaEsp, int velocidad) {
        setBackground(new Color(27, 29, 77));
        this.graph = new BarGraph(ps,ataque,defensa,ataqueEsp,defensaEsp,velocidad);
        this.model = graph.getModel();

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        graph.draw(g);
        g.drawImage(image.getImage(),40 ,50,400,400,null);
        g.setFont(f);
        g.drawString(thisname, 180, 30);

    }


    //Singleton del frame

    private synchronized static void createFrame(){
        if(frame == null)
            frame = new JFrame();
    }

    private static JFrame getFrame(){
        if(frame == null)  createFrame();
        return frame;

    }


    public static void start(String path, String name, int ps, int ataque, int defensa, int ataqueEsp, int defensaEsp, int velocidad) {
        thisPath = path;
        thisname = name;
        JFrame frame = getFrame();
        frame.setTitle("Stats de " + name);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(480, 840);
        frame.setLocationRelativeTo(null);
        frame.setLocation(1000,1000);

        frame.add(new Stats(ps,ataque,defensa,ataqueEsp,defensaEsp,velocidad));
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
