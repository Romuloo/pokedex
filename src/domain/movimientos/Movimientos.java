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
package domain.movimientos;

import DAO.Conexion;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

import java.util.ArrayList;

/**
 *
 * @author Javier Linares Castrillon
 * @author Andrés Iturria Soler
 *
 */

/**
 * Clase encargada de generar el panel de los Movimientos.
 */
public class Movimientos extends JPanel {

    private DefaultListModel modelo = new DefaultListModel();
    private JList<String> list = new JList<String>();
    private JScrollPane s = new JScrollPane(list);
    private Fondo f = new Fondo();
    private Font font = new Font("Calibri", Font.BOLD, 20);
    private Font fontFields = new Font("Calibri", Font.BOLD, 20);
    private Font fontAux = new Font("Calibri", Font.BOLD, 10);
    private Font fontFieldsDesc = new Font("Calibri", Font.BOLD, 15);


    private JLabel l1 = new JLabel("Nombre:");
    private JLabel l2 = new JLabel("Puntos de Poder:");
    private JLabel l3 = new JLabel("Potencia:");
    private JLabel l4 = new JLabel("Precisión:");
    private JLabel l5 = new JLabel("Tipo:");
    private JLabel l6 = new JLabel("Descripción:");

    private JTextField fieldNombre, fieldPP, fieldPot, fieldPre, fieldDesc;
    private ImageIcon tipo = new ImageIcon("res/imagenes/tipos/9.png");

    private JLabel l7 = new JLabel(tipo);

    private ArrayList<Ataque> ataques = new ArrayList<>();
    private ArrayList<Maquina> maquinas = new ArrayList<>();

    private Color x = new Color(13, 175, 207);
    private Color y = new Color(127, 28, 23, 253);


    private JTextField fieldMaquina;


    private ArrayList<Ataque> ataques(){
        if(ataques.isEmpty())
             for(int i = 0; i < Conexion.getAtaques().size(); i++)
                 ataques.add(Conexion.getAtaques().get(i));
             return ataques;
    }

    private ArrayList<Maquina> maquinas(){
        if(maquinas.isEmpty()) for(int i = 0; i < Conexion.maquinas().size(); i++)
            maquinas.add(Conexion.maquinas().get(i));
        return maquinas;
    }

    private void initList(){
        setModelo();
        list.setBackground(Color.getColor("blue", x));
        s.setBackground(Color.blue);
        s.setBounds(0,0,150,(1061/3)*2-20);
        add(s, BorderLayout.WEST);

    }

    private void initFondo(){
        f.setLayout(null);
        f.setBounds(150,0,(1500/3)*2, (1061/3)*2);


        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addListSelectionListener(new Movimientos.Oyente());
        list.setForeground(Color.black);

        int indice=0;
        fieldNombre= new JTextField(ataques().get(indice).getNombre());
        fieldPP = new JTextField(Integer.toString(ataques().get(indice).getPp()));
        fieldPot = new JTextField(Integer.toString(ataques().get(indice).getPotencia()));
        fieldPre = new JTextField(Integer.toString(ataques().get(indice).getPrecision()));
        fieldDesc = new JTextField(ataques().get(indice).getDescripcion());

        fieldMaquina = new JTextField(" ");


        Maquina m = new Maquina();
        m.setNombreAtaque(ataques().get(indice).getNombre());

        if(maquinas().contains(m)){
            if(fieldMaquina != null) f.remove(fieldMaquina);
            String nombre = maquinas().get(maquinas().indexOf(m)).getNombre();
            fieldMaquina.setText(nombre);
        }


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

        fieldMaquina.setOpaque(false);
        fieldMaquina.setBorder(null);
        fieldMaquina.setFont(fontFields);
        fieldMaquina.setForeground(Color.WHITE);


        l1.setFont(font);
        l2.setFont(font);
        l3.setFont(font);
        l4.setFont(font);
        l5.setFont(font);
        l6.setFont(font);

        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(l5);
        f.add(l6);
        f.add(l7);

        l1.setBounds(75,50+100+100-60, 150,40);
        l2.setBounds(75,100+100+100-60,315,40);
        l3.setBounds(75+400,150+100-60,180,40);
        l4.setBounds(75+400,200+100-60,180,40);
        l5.setBounds(75,290,240,40);
        l6.setBounds(40,350,240,40);
        l7.setBounds(270,290,60,40);

        f.add(fieldNombre);
        f.add(fieldPP);
        f.add(fieldPot);
        f.add(fieldPre);
        f.add(fieldDesc);
        f.add(fieldMaquina);


        fieldNombre.setBounds(270,50+100+100-60,175+30,40);
        fieldPP.setBounds(270,100+100+100-60,100,40);
        fieldPot.setBounds(270+400,150+100-60,100,40);
        fieldPre.setBounds(270+400,200+100-60,100,40);

        fieldDesc.setBounds(40,480-60,900,40);
        fieldMaquina.setBounds(270 + 70, 250 + 100 - 60, 60, 40);



        l1.setForeground(Color.getColor("red", y));
        l2.setForeground(Color.getColor("red", y));
        l3.setForeground(Color.getColor("red", y));
        l4.setForeground(Color.getColor("red", y));
        l5.setForeground(Color.getColor("red", y));
        l6.setForeground(Color.getColor("red", y));


        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(l6);
        f.add(l7);

        add(f, BorderLayout.CENTER);
    }

    private void addAtaques(){

        for(int i = 0; i < ataques().size(); i++) modelo.add(i, " " + ataques().get(i).getNombre());
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


    /**
     * Esta clase actúa de Observer para la calse Movimiento.
     */
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

            fieldMaquina.setText(" ");

            if(ataques().get(indice).getDescripcion().length() > 150) {
                fieldDesc.setFont(fontAux);
                fieldDesc.setText(ataques().get(indice).getDescripcion());
            }
            else{
                fieldDesc.setFont(fontFieldsDesc);
                fieldDesc.setText(ataques().get(indice).getDescripcion());
            }

            Maquina m = new Maquina();
            m.setNombreAtaque(ataques().get(indice).getNombre());

            if(maquinas().contains(m)){
                if(fieldMaquina != null) f.remove(fieldMaquina);
                String nombre = maquinas().get(maquinas().indexOf(m)).getNombre();
                fieldMaquina.setText(nombre);
                f.add(fieldMaquina);
            }



            f.remove(l7);
            tipo = new ImageIcon(ataques().get(indice).getTipo());
            l7 = new JLabel(tipo);
            f.add(l7);
            l7.setBounds(270,250+100-60,60,40);


            }
        }
    }
}

