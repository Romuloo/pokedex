package domain.movimientos;

import DAO.Conexion;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Movimientos extends JPanel {

    private DefaultListModel modelo = new DefaultListModel();
    private JList<String> list = new JList<String>();
    private JScrollPane s = new JScrollPane(list);


    private ArrayList<Ataque> ataques(){
        return Conexion.movimientos();
    }


    private void initList(){
        setModelo();
        list.setBackground(Color.lightGray);
        s.setBackground(Color.red);
        s.setBounds(0,0,150,(1061/3)*2 -20);
        add(s, BorderLayout.WEST);

    }

    private void addAtaques(){

        for(int i = 0; i < ataques().size(); i++) modelo.add(i, ataques().get(i).getNombre());
    }


    private void setModelo(){
        if(modelo.isEmpty()) addAtaques();
        list.setModel(modelo);
    }



    public Movimientos(){
        setLayout(null);
        initList();


    }

}
