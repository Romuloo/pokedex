package app;
import domain.localizacion.*;
import domain.stats.*;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        PanelMapa p = new PanelMapa();
        //Stats.start("res/imagenes/fotos/4.png", "Charmander",200,149,101,190,100,130);
        JFrame f = new JFrame();
        f.add(p);
        f.setTitle("Mapa");

        f.setSize(((1500/3)*2)+100,(1061/3)*2);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setResizable(false);

    }
}
