package domain.localizacion;

import domain.stats.Stats;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Javier Linares Castrillon
 */
public class PanelMapa  extends JPanel{

    private DefaultListModel modelo = new DefaultListModel();
    private JList<String> list = new JList<String>();
    private JScrollPane s = new JScrollPane(list);


    private ArrayList<String> pokemons(){

        ArrayList<String> pokemons = new ArrayList<>();

        for(int i = 0; i <100; i++) pokemons.add(" i " + i + " i");
        return pokemons;
    }



    //JList
    private void initList(){

        s.setBounds(0,0,100,(1061/3)*2);
        add(s, BorderLayout.WEST);

    }

    private void addPokemons(){

        for(int i = 0; i < pokemons().size(); i++) modelo.add(i, pokemons().get(i));
    }

    private void removePokemons(){
        for(int i = pokemons().size() - 1; i >= 0; i--) modelo.remove(i);
    }

    private void setModelo(){
        addPokemons();
        list.setModel(modelo);
    }

    //Panel Imagen
    private void initImagen(){
        Imagen i = new Imagen();
        i.setLayout(null);
        i.setBounds(100,0, (1500/3)*2, (1061/3)*2);

        //Image icon
        ImageIcon in = new ImageIcon("res/imagenes/icon.png");
        add(i, BorderLayout.CENTER);
        JButton b1 = new JButton();
        i.add(b1, BorderLayout.CENTER);
        b1.setBounds(0,0, 30,30);


        b1.setIcon(new ImageIcon(in.getImage().getScaledInstance(b1.getWidth(), b1.getHeight(), Image.SCALE_SMOOTH)));
        b1.setOpaque(true);
        b1.setContentAreaFilled(false);
        b1.setBorderPainted(false);
        b1.setBorder(null);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(modelo.isEmpty()) setModelo();
               else if(!modelo.isEmpty()) removePokemons();
            }
        });

    }



    public PanelMapa(){
       setLayout(null);
       new BorderLayout();
       initList();
       initImagen();

    }


}



