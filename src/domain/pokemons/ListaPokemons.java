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

package domain.pokemons;

import static DAO.Conexion.getPokemons;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


import domain.ataques.Ataques;
import domain.stats.Pokemon;
import domain.stats.Stats;


/**
 *
 * @author Javier Linares Castrillon
 * @author Andrés Iturria Soler
 *
 */

/**
 * Clase encargada de generar el panel de Pokemons. Panel principal.
 */
public class ListaPokemons extends JPanel {

    private JList list;
    private DefaultListModel listModel;
    private JScrollPane listScrollPane;
    private JTextField fieldNombre, fieldCategoria, fieldPeso, fieldAltura;
    private JLabel labelNombre, labelCategoria, labelPeso, labelAltura, imageLabel, flecha1, flecha2;
    private JLabel labelEvo1, labelEvo2, labelEvo3, fieldTipo1, fieldTipo2, tituloTipo1, tituloTipo2;
    private ArrayList<Pokemon> pokemons;
    private ImageIcon imagenPrueba, flecha, imageEvo1, imageEvo2, imageEvo3, imageTipo1, imageTipo2;
    private Font fontFields = new Font("Calibri", Font.BOLD, 16);
    private Font font = new Font("Calibri", Font.BOLD, 16);

    private Color x = new Color(13, 175, 207);

    private ImageIcon in = new ImageIcon("res/imagenes/iconoStats.png");
    private ImageIcon ing = new ImageIcon("res/imagenes/iconAtaque.png");

    private JButton stats = new JButton();
    private JButton ataques = new JButton();




    private ArrayList<Pokemon> initPokemons(){
        if(pokemons == null) pokemons = getPokemons();
        return pokemons;
    }

    private void initLista(){

        listModel = new DefaultListModel();
        for (int i = 0; i <= 150; i++) {
            listModel.addElement(" " + initPokemons().get(i).getId() +  "  " + initPokemons().get(i).getName());
        }


        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.setBackground(Color.WHITE);
        list.addListSelectionListener(new Oyente());
        listScrollPane = new JScrollPane(list);
        add(listScrollPane);
        list.setBackground(Color.getColor("blue", x));
        listScrollPane.setBackground(Color.blue);
        listScrollPane.setBounds(0, 0, 150, (1061 / 3) * 2 - 20);
        //Fin de Lista
        setBackground(Color.green);

    }

    private void initComponentes(){
        labelNombre = new JLabel("Nombre");
        labelCategoria = new JLabel("Categoria");
        labelPeso = new JLabel("Peso");
        labelAltura = new JLabel("Altura");

        labelNombre.setFont(font);
        labelCategoria.setFont(font);
        labelPeso.setFont(font);
        labelAltura.setFont(font);

        labelNombre.setForeground(Color.darkGray);
        labelCategoria.setForeground(Color.darkGray);
        labelPeso.setForeground(Color.darkGray);
        labelAltura.setForeground(Color.darkGray);


        int indice = 0; //Para el valor inicial de los campos.
        fieldNombre = new JTextField(pokemons.get(indice).getName());
        fieldNombre.setHorizontalAlignment(JTextField.CENTER);

        fieldCategoria = new JTextField(pokemons.get(indice).getCategoria());
        fieldCategoria.setHorizontalAlignment(JTextField.CENTER);

        fieldPeso = new JTextField(Double.toString(pokemons.get(indice).getPeso()));
        fieldPeso.setHorizontalAlignment(JTextField.CENTER);

        fieldAltura = new JTextField(Double.toString(pokemons.get(indice).getAltura()));
        fieldAltura.setHorizontalAlignment(JTextField.CENTER);


        add(labelNombre);
        add(fieldNombre);

        labelNombre.setBounds(275, 50+50+30+20, 150, 30);
        fieldNombre.setBounds(260, 75+50+30+20, 100, 30);

        add(labelCategoria);
        add(fieldCategoria);

        labelCategoria.setBounds(270, 125+50+30+20, 150, 30);
        fieldCategoria.setBounds(260, 150+50+30+20, 100, 30);

        add(labelPeso);
        add(fieldPeso);

        labelPeso.setBounds(285, 200+50+30+20, 100, 30);
        fieldPeso.setBounds(255, 225+50+30+20, 100, 30);

        add(labelAltura);
        add(fieldAltura);

        labelAltura.setBounds(282, 275+50+30+20, 100, 30);
        fieldAltura.setBounds(260, 300+50+30+20, 100, 30);

        fieldNombre.setOpaque(false);
        fieldNombre.setBorder(null);
        fieldNombre.setFont(fontFields);
        fieldNombre.setForeground(Color.WHITE);

        fieldAltura.setOpaque(false);
        fieldAltura.setBorder(null);
        fieldAltura.setFont(fontFields);
        fieldAltura.setForeground(Color.WHITE);

        fieldPeso.setOpaque(false);
        fieldPeso.setBorder(null);
        fieldPeso.setFont(fontFields);
        fieldPeso.setForeground(Color.WHITE);

        fieldCategoria.setOpaque(false);
        fieldCategoria.setBorder(null);
        fieldCategoria.setFont(fontFields);
        fieldCategoria.setForeground(Color.WHITE);


        //Comienza imagen pokemon y tipos
        imagenPrueba = new ImageIcon(pokemons.get(indice).getPath());
        imageLabel = new JLabel(imagenPrueba);
        add(imageLabel);
        imageLabel.setBounds(500, 25+100, 300, 300);


        tituloTipo1 = new JLabel("Tipo 1");
        tituloTipo2 = new JLabel("Tipo 2");
        add(tituloTipo1);
        add(tituloTipo2);
        tituloTipo1.setFont(font);
        tituloTipo2.setFont(font);

        tituloTipo1.setForeground(Color.darkGray);
        tituloTipo2.setForeground(Color.darkGray);


        tituloTipo1.setBounds(548, 300+60, 150, 50);
        tituloTipo2.setBounds(698, 300+60, 150, 50);


        imageTipo1 = new ImageIcon("res/imagenes/tipos/" + Integer.toString(pokemons.get(indice).getTipo(0)) + ".png");
        fieldTipo1 = new JLabel(imageTipo1);
        add(fieldTipo1);
        fieldTipo1.setBounds(500, 325+60, 150, 50);


        imageTipo2 = new ImageIcon("res/imagenes/tipos/" + Integer.toString(pokemons.get(indice).getTipo(1)) + ".png");
        fieldTipo2 = new JLabel(imageTipo2);
        add(fieldTipo2);
        fieldTipo2.setBounds(650, 325+60, 150, 50);
        //Termina imagen Pokemon y tipos


        //Comienza evoluciones
        flecha = new ImageIcon("res/imagenes/flecha.png");
        Pokemon pokemonSeleccionado = pokemons.get(indice);
        ArrayList<Integer> lineaEvo = pokemonSeleccionado.getLineaEvo();
        int evo1 = lineaEvo.get(0) - 1;
        int evo2 = lineaEvo.get(1) - 1;
        int evo3 = lineaEvo.get(2) - 1;

        imageEvo1 = new ImageIcon(pokemons.get(evo1).getPath());
        imageEvo2 = new ImageIcon(pokemons.get(evo2).getPath());
        imageEvo3 = new ImageIcon(pokemons.get(evo3).getPath());
        labelEvo1 = new JLabel(imageEvo1);
        labelEvo2 = new JLabel(imageEvo2);
        labelEvo3 = new JLabel(imageEvo3);

        flecha1 = new JLabel(flecha);
        flecha2 = new JLabel(flecha);

        add(labelEvo1);
        add(labelEvo2);
        add(labelEvo3);
        add(flecha1);
        add(flecha2);

        labelEvo1.setBounds(100 + 150, 450, 200, 220);
        labelEvo2.setBounds(400 + 150, 450, 200, 220);
        labelEvo3.setBounds(700 + 150, 450, 200, 220);
        flecha1.setBounds(325 + 150, 525, 50, 50);
        flecha2.setBounds(625 + 150, 525, 50, 50);
        //Termina evoluciones



        stats.setBounds(900, 200, 70, 70);

        stats.setIcon(new ImageIcon(in.getImage().getScaledInstance(stats.getWidth(), stats.getHeight(), Image.SCALE_SMOOTH)));
        stats.setOpaque(true);
        stats.setContentAreaFilled(false);
        stats.setBorderPainted(false);
        stats.setBorder(null);


        add(stats);

        ataques.setBounds(900, 300, 70, 70);

        ataques.setIcon(new ImageIcon(ing.getImage().getScaledInstance(ataques.getWidth(), ataques.getHeight(), Image.SCALE_SMOOTH)));
        ataques.setOpaque(true);
        ataques.setContentAreaFilled(false);
        ataques.setBorderPainted(false);
        ataques.setBorder(null);

        add(ataques);

        stats.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Stats.start(new Oyente().getPokemon());

            }
        });



        ataques.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ataques.ataques(new Oyente().getPokemon());
            }
        });

    }
    /**
     * Constructor de la class
     */
    public ListaPokemons() {
        super();
        setLayout(null);

        initLista();
        initComponentes();
    }


    /**
     * Se encarga de pintar la imagen de fondo del panel.
     * @param grafico
     */
    public void paint(Graphics grafico) {
        ImageIcon Img = new ImageIcon("res/imagenes/fondoPokedex.png");
        grafico.drawImage(Img.getImage(), 150, 0,(1500/3)*2-50, (1061/3)*2, null);


        ImageIcon Imagen = new ImageIcon("res/imagenes/logo.png");
        grafico.drawImage(Imagen.getImage(), 475, 30,1632/5,928/5, null);
        setOpaque(false);
        super.paint(grafico);

    }


    /**
     * Esta clase privada actúa como Observer.
     */
    private class Oyente implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                //Actualizacion de campos de texto
                int indice = list.getSelectedIndex();
                fieldNombre.setText(pokemons.get(indice).getName());
                fieldCategoria.setText(pokemons.get(indice).getCategoria());
                fieldPeso.setText(Double.toString(pokemons.get(indice).getPeso()));
                fieldAltura.setText(Double.toString(pokemons.get(indice).getAltura()));
                //Actualizacion de Tipos
                remove(fieldTipo1);
                remove(fieldTipo2);
                imageTipo1 = new ImageIcon("res/imagenes/tipos/" + Integer.toString(pokemons.get(indice).getTipo(0)) + ".png");
                imageTipo2 = new ImageIcon("res/imagenes/tipos/" + Integer.toString(pokemons.get(indice).getTipo(1)) + ".png");
                fieldTipo1 = new JLabel(imageTipo1);
                fieldTipo2 = new JLabel(imageTipo2);
                add(fieldTipo1);
                add(fieldTipo2);
                fieldTipo1.setBounds(500, 325+60, 150, 50);
                fieldTipo2.setBounds(650, 325+60, 150, 50);


                //Actualizacion de imagenes.
                remove(imageLabel);
                imagenPrueba = new ImageIcon(pokemons.get(indice).getPath());
                imageLabel = new JLabel(imagenPrueba);
                add(imageLabel);
                imageLabel.setBounds(500, 25+100, 300, 300);

                //Actualizacion imagenes evoluciones
                remove(labelEvo1);
                remove(labelEvo2);
                remove(labelEvo3);
                Pokemon pokemonSeleccionado = pokemons.get(indice);
                ArrayList<Integer> lineaEvo = pokemonSeleccionado.getLineaEvo();
                int evo1 = lineaEvo.get(0) - 1;
                int evo2 = lineaEvo.get(1) - 1;
                int evo3 = lineaEvo.get(2) - 1;
                if (evo1 < 0) {
                    evo1 = 151;
                }
                if (evo2 < 0) {
                    evo2 = 151;
                }
                if (evo3 < 0) {
                    evo3 = 151;
                }
                imageEvo1 = new ImageIcon(pokemons.get(evo1).getPath());
                imageEvo2 = new ImageIcon(pokemons.get(evo2).getPath());
                imageEvo3 = new ImageIcon(pokemons.get(evo3).getPath());
                labelEvo1 = new JLabel(imageEvo1);
                labelEvo2 = new JLabel(imageEvo2);
                labelEvo3 = new JLabel(imageEvo3);
                add(labelEvo1);
                add(labelEvo2);
                add(labelEvo3);
                labelEvo1.setBounds(100 + 150, 450, 200, 220);
                labelEvo2.setBounds(400 + 150, 450, 200, 220);
                labelEvo3.setBounds(700 + 150, 450, 200, 220);
                


            }
        }

        /**
         *
         * @return nombre del pokemon seleccionado en la lista.
         */
            public String getPokemon(){
                return pokemons.get(list.getSelectedIndex()).getName();

        }

    }
}
