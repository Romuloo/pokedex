package domain.localizacion;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class PanelMapa  extends JPanel{


    public PanelMapa(){
        setLayout(null);
        new BorderLayout();

        //super("Mapa");

        String[] localizaciones = {"l" , " d" , "d " , " dw" , "dwq" };
        JList<String> list = new JList<String>(localizaciones);
        JScrollPane s = new JScrollPane(list);
        s.setBounds(0,0,100,(1061/3)*2);

        Imagen i = new Imagen();
        i.setLayout(null);
        i.setBounds(100,0, (1500/3)*2, (1061/3)*2);



        JButton b = new JButton();
        i.add(b, BorderLayout.CENTER);
        b.setBounds(0,0, 30,30);

        ImageIcon in = new ImageIcon("res/imagenes/icon.png");
        b.setIcon(new ImageIcon(in.getImage().getScaledInstance(b.getWidth(), b.getHeight(), Image.SCALE_SMOOTH)));
        b.setOpaque(true);
        b.setContentAreaFilled(false);
        b.setBorderPainted(false);
        b.setBorder(null);

        add(i, BorderLayout.CENTER);
        //this.add(s, BorderLayout.WEST);
        add(s, BorderLayout.WEST);
        //add(p1, BorderLayout.WEST);




    }


}



