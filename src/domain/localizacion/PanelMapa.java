package domain.localizacion;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class PanelMapa  extends JFrame{


    public PanelMapa(){


        super("Mapa");
        String[] localizaciones = {""};

        JList<String> list = new JList<String>(localizaciones);
        JScrollPane s = new JScrollPane(list);
        s.setPreferredSize(new Dimension(100, 1061/2));



        Imagen i = new Imagen();
        i.setLayout(null);



        JButton b = new JButton();
        b.setBounds(70,100, 30,30);
        i.add(b, BorderLayout.CENTER);

        ImageIcon in = new ImageIcon("res/imagenes/icon.png");
        b.setIcon(new ImageIcon(in.getImage().getScaledInstance(b.getWidth(), b.getHeight(), Image.SCALE_SMOOTH)));
        b.setOpaque(true);
        b.setContentAreaFilled(false);
        b.setBorderPainted(false);
        b.setBorder(null);
        add(s, BorderLayout.WEST);
        add(i, BorderLayout.CENTER);

        this.setSize((1500/2)+100,1061/2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);


    }


}



