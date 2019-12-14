package app.before;

import javax.swing.*;
import java.awt.*;

public class PokedexFondo extends JPanel {

    public PokedexFondo() {
        this.setSize(1600/4, 2846/4);

    }

    /**
     * Pinta el fondo del panel.
     * @param g
     */

    public void paint(Graphics g){


        ImageIcon Img = new ImageIcon("res/imagenes/pokedex.png");
        g.drawImage(Img.getImage(), 0, 0, 1600/4, 2846/4, null);


        setOpaque(false);
        super.paint(g);

    }


}