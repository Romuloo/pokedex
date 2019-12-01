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