package domain.mainPage;

import static DAO.Conexion.getPokemons;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import domain.stats.Pokemon;


/**
 *
 * @author andres
 */
public class ListaPokemons extends JPanel {

    private JList list;
    private DefaultListModel listModel;
    private JScrollPane listScrollPane;
    private BufferedImage image;
    private JTextField fieldNombre, fieldCategoria, fieldPeso, fieldAltura;
    private JLabel labelNombre, labelCategoria, labelPeso, labelAltura, imageLabel, flecha1, flecha2;
    private JLabel labelEvo1, labelEvo2, labelEvo3, fieldTipo1, fieldTipo2, tituloTipo1, tituloTipo2;
    private Pokemon[] pokemons = getPokemons();
    private ImageIcon imagenPrueba, flecha, imageEvo1, imageEvo2, imageEvo3, imageTipo1, imageTipo2;

    public ListaPokemons() throws SQLException {
        super();
        setLayout(null);
        //comienzo de lista

        listModel = new DefaultListModel();
        for(int i=0; i<=150; i++){
            listModel.addElement(pokemons[i].getName());
        }

        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.setBackground(Color.WHITE);
        list.addListSelectionListener(new Oyente());
        listScrollPane = new JScrollPane(list);
        add(listScrollPane);
        listScrollPane.setBounds(0,0,150,400);
        //Fin de Lista

        //Comienzo de campos de texto
        labelNombre = new JLabel("Nombre");
        labelCategoria = new JLabel("Categoria");
        labelPeso = new JLabel("Peso");
        labelAltura = new JLabel("Altura");

        int indice = 0; //Para el valor inicial de los campos.
        fieldNombre = new JTextField(pokemons[indice].getName());
        fieldNombre.setHorizontalAlignment(JTextField.CENTER);

        fieldCategoria = new JTextField(pokemons[indice].getCategoria());
        fieldCategoria.setHorizontalAlignment(JTextField.CENTER);

        fieldPeso = new JTextField(Double.toString(pokemons[indice].getPeso()));
        fieldPeso.setHorizontalAlignment(JTextField.CENTER);

        fieldAltura = new JTextField(Double.toString(pokemons[indice].getAltura()));
        fieldAltura.setHorizontalAlignment(JTextField.CENTER);


        add(labelNombre);
        add(fieldNombre);
        labelNombre.setBounds(275,50, 150,30);
        fieldNombre.setBounds(250,75, 100,30);
        add(labelCategoria);
        add(fieldCategoria);
        labelCategoria.setBounds(270, 125, 150,30);
        fieldCategoria.setBounds(250, 150, 100,30);
        add(labelPeso);
        add(fieldPeso);
        labelPeso.setBounds(285, 200, 100,30);
        fieldPeso.setBounds(250, 225, 100,30);
        add(labelAltura);
        add(fieldAltura);
        labelAltura.setBounds(282, 275, 100,30);
        fieldAltura.setBounds(250, 300, 100, 30);

        //Termina campos de texto

        //Comienza imagen pokemon y tipos
        imagenPrueba = new ImageIcon(pokemons[indice].getPath());
        imageLabel = new JLabel(imagenPrueba);
        add(imageLabel);
        imageLabel.setBounds(500,25,300,300);


        tituloTipo1 = new JLabel("Tipo 1");
        tituloTipo2 = new JLabel("Tipo 2");
        add(tituloTipo1);
        add(tituloTipo2);
        tituloTipo1.setBounds(558,300,150,50);
        tituloTipo2.setBounds(708,300,150,50);


        imageTipo1=new ImageIcon("res/imagenes/tipos/"+Integer.toString(pokemons[indice].getTipo(0))+".png");
        fieldTipo1 = new JLabel(imageTipo1);
        add(fieldTipo1);
        fieldTipo1.setBounds(500,325,150,50);


        imageTipo2= new ImageIcon("res/imagenes/tipos/" + Integer.toString(pokemons[indice].getTipo(1))+".png");
        fieldTipo2 = new JLabel(imageTipo2);
        add(fieldTipo2);
        fieldTipo2.setBounds(650,325,150,50);
        //Termina imagen Pokemon y tipos


        //Comienza evoluciones
        flecha=new ImageIcon("res/imagenes/flecha.png");
        Pokemon pokemonSeleccionado = pokemons[indice];
        ArrayList<Integer> lineaEvo = pokemonSeleccionado.getLineaEvo();
        int evo1=lineaEvo.get(0)-1;
        int evo2=lineaEvo.get(1)-1;
        int evo3=lineaEvo.get(2)-1;

        imageEvo1=new ImageIcon(pokemons[evo1].getPath());
        imageEvo2=new ImageIcon(pokemons[evo2].getPath());
        imageEvo3=new ImageIcon(pokemons[evo3].getPath());
        labelEvo1=new JLabel(imageEvo1);
        labelEvo2=new JLabel(imageEvo2);
        labelEvo3=new JLabel(imageEvo3);

        flecha1 = new JLabel(flecha);
        flecha2 = new JLabel(flecha);

        add(labelEvo1);
        add(labelEvo2);
        add(labelEvo3);
        add(flecha1);
        add(flecha2);
        labelEvo1.setBounds(100, 450, 200, 220);
        labelEvo2.setBounds(400, 450, 200, 220);
        labelEvo3.setBounds(700, 450, 200, 220);
        flecha1.setBounds(325, 525, 50, 50);
        flecha2.setBounds(625, 525, 50, 50);
        //Termina evoluciones

    }


    private class Oyente implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e){
            if (!e.getValueIsAdjusting()){
                //Actualizacion de campos de texto
                int indice=list.getSelectedIndex();
                fieldNombre.setText(pokemons[indice].getName());
                fieldCategoria.setText(pokemons[indice].getCategoria());
                fieldPeso.setText(Double.toString(pokemons[indice].getPeso()));
                fieldAltura.setText(Double.toString(pokemons[indice].getAltura()));

                //Actualizacion de Tipos
                remove(fieldTipo1);
                remove(fieldTipo2);
                imageTipo1 = new ImageIcon("res/imagenes/tipos/" + Integer.toString(pokemons[indice].getTipo(0))+".png");
                imageTipo2 = new ImageIcon("res/imagenes/tipos/" + Integer.toString(pokemons[indice].getTipo(1))+".png");
                fieldTipo1 = new JLabel(imageTipo1);
                fieldTipo2 = new JLabel(imageTipo2);
                add(fieldTipo1);
                add(fieldTipo2);
                fieldTipo1.setBounds(500,325,150,50);
                fieldTipo2.setBounds(650,325,150,50);

                //Actualizacion de imagenes.
                remove(imageLabel);
                imagenPrueba = new ImageIcon(pokemons[indice].getPath());
                imageLabel = new JLabel(imagenPrueba);
                add(imageLabel);
                imageLabel.setBounds(500,25,300,300);

                //Actualizacion imagenes evoluciones
                remove(labelEvo1);
                remove(labelEvo2);
                remove(labelEvo3);
                Pokemon pokemonSeleccionado = pokemons[indice];
                ArrayList<Integer> lineaEvo = pokemonSeleccionado.getLineaEvo();
                int evo1=lineaEvo.get(0)-1;
                int evo2=lineaEvo.get(1)-1;
                int evo3=lineaEvo.get(2)-1;
                if(evo1<0){
                    evo1=151;
                }
                if(evo2<0){
                    evo2=151;
                }
                if(evo3<0){
                    evo3=151;
                }
                imageEvo1=new ImageIcon(pokemons[evo1].getPath());
                imageEvo2=new ImageIcon(pokemons[evo2].getPath());
                imageEvo3=new ImageIcon(pokemons[evo3].getPath());
                labelEvo1=new JLabel(imageEvo1);
                labelEvo2=new JLabel(imageEvo2);
                labelEvo3=new JLabel(imageEvo3);
                add(labelEvo1);
                add(labelEvo2);
                add(labelEvo3);
                labelEvo1.setBounds(100, 450, 200, 220);
                labelEvo2.setBounds(400, 450, 200, 220);
                labelEvo3.setBounds(700, 450, 200, 220);
            }
        }

    }
}
