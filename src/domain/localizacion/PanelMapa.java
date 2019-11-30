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





    //annade pokemons al modelo de la JList
    private void addPokemons(){

        for(int i = 0; i < pokemons().size(); i++) modelo.add(i, pokemons().get(i));
    }

    //elimina pokemons del modelo de la JList
    private void removePokemons(){
        for(int i = pokemons().size() - 1; i >= 0; i--) modelo.remove(i);
    }

    //establece el modelo de la JList
    private void setModelo(){
       if(modelo.isEmpty()) addPokemons();
       else if(!modelo.isEmpty()) removePokemons();
       list.setModel(modelo);
    }

    //JList
    private void initList(){
        list.setBackground(Color.cyan);
        s.setBackground(Color.red);
        s.setBounds(0,0,100,(1061/3)*2);
        add(s, BorderLayout.WEST);

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
        JButton b2 = new JButton();
        JButton b3 = new JButton();
        JButton b4 = new JButton();
        JButton b5 = new JButton();
        JButton b6 = new JButton();
        JButton b7 = new JButton();

        i.add(b1);
        i.add(b2);
        i.add(b3);
        i.add(b4);
        i.add(b5);
        i.add(b6);
        i.add(b7);

        b1.setBounds(109,207, 30,30);
        b2.setBounds(430,68, 30,30);
        b3.setBounds(896,200, 30,30);
        b4.setBounds(613,68, 30,30);
        b5.setBounds(374,635, 30,30);
        b6.setBounds(487,415, 30,30);
        b7.setBounds(219,190, 30,30);


        b1.setIcon(new ImageIcon(in.getImage().getScaledInstance(b1.getWidth(), b1.getHeight(), Image.SCALE_SMOOTH)));
        b1.setOpaque(true);
        b1.setContentAreaFilled(false);
        b1.setBorderPainted(false);
        b1.setBorder(null);

        b2.setIcon(new ImageIcon(in.getImage().getScaledInstance(b2.getWidth(), b2.getHeight(), Image.SCALE_SMOOTH)));
        b2.setOpaque(true);
        b2.setContentAreaFilled(false);
        b2.setBorderPainted(false);
        b2.setBorder(null);

        b3.setIcon(new ImageIcon(in.getImage().getScaledInstance(b3.getWidth(), b3.getHeight(), Image.SCALE_SMOOTH)));
        b3.setOpaque(true);
        b3.setContentAreaFilled(false);
        b3.setBorderPainted(false);
        b3.setBorder(null);

        b4.setIcon(new ImageIcon(in.getImage().getScaledInstance(b4.getWidth(), b4.getHeight(), Image.SCALE_SMOOTH)));
        b4.setOpaque(true);
        b4.setContentAreaFilled(false);
        b4.setBorderPainted(false);
        b4.setBorder(null);

        b5.setIcon(new ImageIcon(in.getImage().getScaledInstance(b5.getWidth(), b5.getHeight(), Image.SCALE_SMOOTH)));
        b5.setOpaque(true);
        b5.setContentAreaFilled(false);
        b5.setBorderPainted(false);
        b5.setBorder(null);

        b6.setIcon(new ImageIcon(in.getImage().getScaledInstance(b6.getWidth(), b6.getHeight(), Image.SCALE_SMOOTH)));
        b6.setOpaque(true);
        b6.setContentAreaFilled(false);
        b6.setBorderPainted(false);
        b6.setBorder(null);

        b7.setIcon(new ImageIcon(in.getImage().getScaledInstance(b7.getWidth(), b7.getHeight(), Image.SCALE_SMOOTH)));
        b7.setOpaque(true);
        b7.setContentAreaFilled(false);
        b7.setBorderPainted(false);
        b7.setBorder(null);






        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setModelo();
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setModelo();
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setModelo();
            }
        });

    }


    /**
     * Construye un PanelMapa
     */

    public PanelMapa(){
       setLayout(null);
       new BorderLayout();
       initList();
       initImagen();

    }


}



