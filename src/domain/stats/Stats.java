package domain.stats;

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



    public static void start(String path, String name, int ps, int ataque, int defensa, int ataqueEsp, int defensaEsp, int velocidad) {
        thisPath = path;
        thisname = name;
        JPanel panel = new CustomPanel();
        JFrame frame = new JFrame("Stats de " + name);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480, 840);
        frame.setLocationRelativeTo(null);
        frame.add(new Stats(ps,ataque,defensa,ataqueEsp,defensaEsp,velocidad));
        frame.setVisible(true);
        frame.setResizable(false);
        frame.add(panel);
    }
}
