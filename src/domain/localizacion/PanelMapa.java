/**
 Copyright [2019] [Andres Iturria Soler, Javier Linares Castrillon, Samuel Aragones Lozano]
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at
 http://www.apache.org/licenses/LICENSE-2.0
 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.

 */

package domain.localizacion;

import DAO.Conexion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Javier Linares Castrillon
 * @author Andrés Iturria Soler
 *
 */

/**
 * Clase encargada de general el Panel de las Localizaciones.
 */

public class PanelMapa  extends JPanel{

    private DefaultListModel modelo = new DefaultListModel();
    private JList<String> list = new JList<String>();
    private JScrollPane s = new JScrollPane(list);

    private Imagen i = new Imagen();
    private ImageIcon in = new ImageIcon("res/imagenes/localizaciones.png");
    private ImageIcon help = new ImageIcon("res/imagenes/help.png");

    private int indexLocalizacion;
    private Color x = new Color(13, 175, 207);


    private String[] localizaciones = {"Calle Victoria", "Bosque Verde", "Monte Moon", "Cueva Celeste", "Torre Pokemon", "Zona Safari", "Islas Espuma"};


    private ArrayList<String> pokemons() {
        return Conexion.pokemonLocalizaciones(indexLocalizacion);
    }

    private ImageIcon aux = new ImageIcon("res/imagenes/icon.png");
    private Icon ayuda = new ImageIcon(aux.getImage().getScaledInstance(512/10, 512/10, Image.SCALE_DEFAULT));

    //annade pokemons al modelo de la JList
    private void addPokemons(){
        for(int i = 0; i < pokemons().size(); i++) modelo.add(i, pokemons().get(i));
    }

    //elimina pokemons del modelo de la JList
    private void removePokemons(){
        modelo.removeAllElements();
    }

    //establece el modelo de la JList
    private void setModelo(int c){
        removePokemons();
        this.indexLocalizacion = c;
        addPokemons();
        list.setModel(modelo);
    }

    //JList
    private void initList(){
        list.setBackground(Color.getColor("blue", x));
        s.setBackground(Color.blue);
        s.setBounds(0,0,100,(1061/3)*2);
        add(s, BorderLayout.WEST);

    }

    //Panel Imagen
    private void initImagen(){




        i.setLayout(null);
        i.setBounds(100,0, (1500/3)*2, (1061/3)*2);

        //Image icon
        add(i, BorderLayout.CENTER);

        //Botones
        JButton b1 = new JButton();
        JButton b2 = new JButton();
        JButton b3 = new JButton();
        JButton b4 = new JButton();
        JButton b5 = new JButton();
        JButton b6 = new JButton();
        JButton b7 = new JButton();
        JButton b8 = new JButton();


        i.add(b1);
        i.add(b2);
        i.add(b3);
        i.add(b4);
        i.add(b5);
        i.add(b6);
        i.add(b7);
        i.add(b8);

        b1.setBounds(109,207, (1000/10)/3,(1200/10)/3);
        b2.setBounds(430,68, (1000/10)/3,(1200/10)/3);
        b3.setBounds(896,200, (1000/10)/3,(1200/10)/3);
        b4.setBounds(613,68, (1000/10)/3,(1200/10)/3);
        b5.setBounds(374,635, (1000/10)/3,(1200/10)/3);
        b6.setBounds(487,415, (1000/10)/3,(1200/10)/3);
        b7.setBounds(219,190, (1000/10)/3,(1200/10)/3);
        b8.setBounds(30,30,45,45);

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

        b8.setIcon(new ImageIcon(help.getImage().getScaledInstance(b8.getWidth(), b8.getHeight(), Image.SCALE_SMOOTH)));
        b8.setOpaque(true);
        b8.setContentAreaFilled(false);
        b8.setBorderPainted(false);
        b8.setBorder(null);



        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { setModelo(1); }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { setModelo(3); }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { setModelo(5); }
        });

        b4.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { setModelo(4); }
        }));

        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { setModelo(7); }
        });

        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { setModelo(6); }
        });

        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setModelo(2);

            }
        });
        b8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object o = JOptionPane.showInputDialog(b8, "Elige la Localización", "Localizaciones" ,JOptionPane.QUESTION_MESSAGE,
                        ayuda, localizaciones, localizaciones[0]);

                   try {
                        if (o.toString().equalsIgnoreCase("Calle Victoria")) setModelo(1);
                        if (o.toString().equalsIgnoreCase("Bosque Verde")) setModelo(2);
                        if (o.toString().equalsIgnoreCase("Monte Moon")) setModelo(3);
                        if (o.toString().equalsIgnoreCase("Cueva Celeste")) setModelo(4);
                        if (o.toString().equalsIgnoreCase("Torre Pokemon")) setModelo(5);
                        if (o.toString().equalsIgnoreCase("Zona Safari")) setModelo(6);
                        if (o.toString().equalsIgnoreCase("Islas Espuma")) setModelo(7);

                   }catch (NullPointerException ne){
                       System.out.println("Le has dado a cancelar, no pasa nada, yo te recojo la excepción :)");
                   }


            }

        });


    }


    /**
     * Construye un PanelMapa.
     */

    public PanelMapa(){
       setLayout(null);
       new BorderLayout();
       initList();
       initImagen();

    }


}



