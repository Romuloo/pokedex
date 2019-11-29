package domain.localizacion;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;

public class Imagen extends JPanel {

    public Imagen() {

        this.setSize((1500/3)*2, (1061/3)*2);
    }


    public void paint(Graphics grafico) {

        Dimension height = getSize();

        ImageIcon Img = new ImageIcon("res/imagenes/kanto.png");


        grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);



        setOpaque(false);

        super.paint(grafico);
    }
}

