package domain.movimientos;

import DAO.Conexion;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Movimientos extends JPanel {

    private DefaultListModel modelo = new DefaultListModel();
    private JList<String> list = new JList<String>();
    private JScrollPane s = new JScrollPane(list);
    private Fondo f = new Fondo();
    private Font font = new Font("Calibri", Font.BOLD, 20);

    private JLabel l1 = new JLabel("Nombre");
    private JLabel l2 = new JLabel("Puntos de Poder");
    private JLabel l3 = new JLabel("Potencia");
    private JLabel l4 = new JLabel("Precisión");
    private JLabel l5 = new JLabel("Prioridad");
    private JLabel l6 = new JLabel("Descripción");
    private JLabel l7 = new JLabel("Tipo");

    private JTextField fieldNombre, fieldCategoria, fieldPeso, fieldAltura, fieldPruebaImagenTipo1, fieldPruebaImagenTipo2;






    private ArrayList<Ataque> ataques(){
        return Conexion.movimientos();

    }


    private void initList(){
        setModelo();
        list.setBackground(Color.cyan);
        s.setBackground(Color.red);
        s.setBounds(0,0,150,(1061/3)*2 -20);
        add(s, BorderLayout.WEST);

    }

    private void initFondo(){
        f.setLayout(null);
        f.setBounds(150,0,(1500/3)*2, (1061/3)*2);

        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(l5);
        f.add(l6);
        f.add(l7);

        l1.setForeground(Color.blue);
        l2.setForeground(Color.blue);
        l3.setForeground(Color.blue);
        l4.setForeground(Color.blue);
        l5.setForeground(Color.blue);
        l6.setForeground(Color.blue);
        l7.setForeground(Color.blue);



        l1.setFont(font);
        l2.setFont(font);
        l3.setFont(font);
        l4.setFont(font);
        l5.setFont(font);
        l6.setFont(font);
        l7.setFont(font);

        l1.setBounds(100,100,60*3,40);
        l2.setBounds(100,160,105*3,40);
        l3.setBounds(100,220,60*3,40);
        l4.setBounds(100,280,60*3,40);
        l5.setBounds(100,340,60*3,40);
        l6.setBounds(100,400,80*3,40);
        l7.setBounds(100,460,60*3,40);

       // f.add(l2);



        add(f, BorderLayout.CENTER);
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
        initFondo();

    }

}
