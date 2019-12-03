package domain.movimientos;

import javax.swing.*;
import java.awt.*;

public class Movimientos extends JPanel {

    private DefaultListModel modelo = new DefaultListModel();
    private JList<String> list = new JList<String>();
    private JScrollPane s = new JScrollPane(list);



    private void initList(){
        list.setBackground(Color.lightGray);
        s.setBackground(Color.red);
        s.setBounds(0,0,100,(1061/3)*2 -20);
        add(s, BorderLayout.WEST);

    }

    public Movimientos(){
        setLayout(null);
        initList();


    }

}
