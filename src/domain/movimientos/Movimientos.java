package domain.movimientos;

import DAO.Conexion;
import domain.stats.Pokemon;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.ArrayList;

public class Movimientos extends JPanel {

    private DefaultListModel modelo = new DefaultListModel();
    private JList<String> list = new JList<String>();
    private JScrollPane s = new JScrollPane(list);
    private Fondo f = new Fondo();
    private Font font = new Font("Calibri", Font.BOLD, 20);
    private Font fontFields = new Font("Calibri", Font.BOLD, 20);
    private Font fontTitulo = new Font("Calibri", Font.BOLD, 36);
    private Font fontFieldsDesc = new Font("Calibri", Font.BOLD, 15);


    private JLabel l1 = new JLabel("Nombre:");
    private JLabel l2 = new JLabel("Puntos de Poder:");
    private JLabel l3 = new JLabel("Potencia:");
    private JLabel l4 = new JLabel("Precisión:");
    private JLabel l5 = new JLabel("Tipo:");
    private JLabel l6 = new JLabel("Descripción:");
    private JLabel l8 = new JLabel("Movimientos");

    private JTextField fieldNombre, fieldPP, fieldPot, fieldPre, fieldDesc;
    private ImageIcon tipo = new ImageIcon("res/imagenes/tipos/9.png");

    private JLabel l7 = new JLabel(tipo);

    private ArrayList<Ataque> ataques = new ArrayList<>();





    private ArrayList<Ataque> ataques(){
        if(ataques.isEmpty())
             for(int i = 0; i < Conexion.getAtaques().size(); i++)
                 ataques.add(Conexion.getAtaques().get(i));
             return ataques;
    }

    private void initList(){
        setModelo();
        list.setBackground(Color.darkGray);
        s.setBackground(Color.red);
        s.setBounds(0,0,150,(1061/3)*2-10);
        add(s, BorderLayout.WEST);

    }

    private void initFondo(){
        f.setLayout(null);
        f.setBounds(150,0,(1500/3)*2, (1061/3)*2);



        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addListSelectionListener(new Movimientos.Oyente());
        list.setForeground(Color.white);





        int indice=0;
        fieldNombre= new JTextField(ataques().get(indice).getNombre());
        fieldPP = new JTextField(Integer.toString(ataques().get(indice).getPp()));
        fieldPot = new JTextField(Integer.toString(ataques().get(indice).getPotencia()));
        fieldPre = new JTextField(Integer.toString(ataques().get(indice).getPrecision()));
        fieldDesc = new JTextField(ataques().get(indice).getDescripcion());

        fieldNombre.setOpaque(false);
        fieldNombre.setBorder(null);
        fieldNombre.setFont(fontFields);
        fieldNombre.setForeground(Color.WHITE);

        fieldPot.setOpaque(false);
        fieldPot.setBorder(null);
        fieldPot.setFont(fontFields);
        fieldPot.setForeground(Color.WHITE);

        fieldPre.setOpaque(false);
        fieldPre.setBorder(null);
        fieldPre.setFont(fontFields);
        fieldPre.setForeground(Color.WHITE);

        fieldPP.setOpaque(false);
        fieldPP.setBorder(null);
        fieldPP.setFont(fontFields);
        fieldPP.setForeground(Color.WHITE);

        fieldDesc.setOpaque(false);
        fieldDesc.setBorder(null);
        fieldDesc.setFont(fontFieldsDesc);
        fieldDesc.setForeground(Color.WHITE);

        l1.setFont(font);
        l2.setFont(font);
        l3.setFont(font);
        l4.setFont(font);
        l5.setFont(font);
        l6.setFont(font);
        l8.setFont(fontTitulo);

        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(l5);
        f.add(l6);
        f.add(l7);
        f.add(l8);

        l1.setBounds(75,50+100+100, 150,40);
        l2.setBounds(75,100+100+100,105*3,40);
        l3.setBounds(75+400,150+100,60*3,40);
        l4.setBounds(75+400,200+100,60*3,40);
        l5.setBounds(75,250+100,80*3,40);
        l6.setBounds(40,450,80*3,40);
        l7.setBounds(270,250+100,60,40);
        l8.setBounds((1061/3)-50, 40, 400,90);

        f.add(fieldNombre);
        f.add(fieldPP);
        f.add(fieldPot);
        f.add(fieldPre);
        f.add(fieldDesc);


        fieldNombre.setBounds(270,50+100+100,175,40);
        fieldPP.setBounds(270,100+100+100,100,40);
        fieldPot.setBounds(270+400,150+100,100,40);
        fieldPre.setBounds(270+400,200+100,100,40);

        fieldDesc.setBounds(40,480,930,40);



        l1.setForeground(Color.lightGray);
        l2.setForeground(Color.lightGray);
        l3.setForeground(Color.lightGray);
        l4.setForeground(Color.lightGray);
        l5.setForeground(Color.lightGray);
        l6.setForeground(Color.lightGray);
        l8.setForeground(Color.lightGray);


        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(l6);
        f.add(l7);



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


private class Oyente implements ListSelectionListener {

    @Override
    public void valueChanged(ListSelectionEvent e){
        if (!e.getValueIsAdjusting()){
            //Actualizacion de campos de texto
            int indice=list.getSelectedIndex();
            fieldNombre.setText(ataques().get(indice).getNombre());
            fieldPP.setText((Integer.toString(ataques().get(indice).getPp())));
            fieldPot.setText(Integer.toString(ataques().get(indice).getPotencia()));
            fieldPre.setText(Integer.toString(ataques().get(indice).getPrecision()));
            fieldDesc.setText(ataques().get(indice).getDescripcion());

            f.remove(l7);
            tipo = new ImageIcon(ataques().get(indice).getTipo());
            l7 = new JLabel(tipo);
            f.add(l7);
            l7.setBounds(270,250+100,60,40);


            }
        }
    }
}

