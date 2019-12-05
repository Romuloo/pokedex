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
package domain.ataques;

import DAO.Conexion;
import domain.stats.Pokemon;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author Javier Linares Castrillon
 */

public class Ataques extends JPanel {



    private static String pokeName;
    private static String thisPath;
    private static JFrame frame;
    private Pokemon p;

    private DefaultListModel modelo = new DefaultListModel();
    private JList<String> list = new JList<String>();
    private JScrollPane s = new JScrollPane(list);


   // private ImageIcon image = new ImageIcon(thisPath);
    private Font f = new Font("Calibri", Font.BOLD, 26);



    //Provisional
    private ArrayList<String> ataques(){
        return Conexion.pokemonMovimientos(pokeName);
    }

    public Ataques(String name) {
        p = Conexion.pokemonNombrePath(name);
        thisPath = p.getPath();
        pokeName = p.getName();
        setLayout(null);
        setBackground(new Color(146, 207, 138));
        initList();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon image = new ImageIcon(thisPath);
        g.drawImage(image.getImage(),40 ,50,400,400,null);
        g.setFont(f);
        g.setColor(Color.darkGray);
        g.drawString(pokeName, 180, 30);

    }
    private void addAtaques(){

        for(int i = 0; i < ataques().size(); i++) modelo.add(i, ataques().get(i));
    }

    private void removePokemons(){
        for(int i = ataques().size() - 1; i >= 0; i--) modelo.remove(i);
    }

    private void setModelo(){
        if(modelo.isEmpty()) addAtaques();
        else if(!modelo.isEmpty()) removePokemons();
        list.setModel(modelo);
    }

    private void initList(){
        setModelo();
        list.setBackground(Color.pink);
        s.setBackground(Color.green);
        s.setBounds(5,460,470,310);
        add(s);

    }


    private synchronized static void frameManager(){
        if(frame == null) frame = new JFrame();
        else if(frame != null) frameManagerAux();
    }
    private synchronized static void frameManagerAux(){
        frame.dispose();
        frame = new JFrame();

    }


    public static void ataques(String name) {


        frameManager();
        frame.setLocationRelativeTo(null);
        frame.setLocation(1000,1000);
        frame.setTitle("Ataques de " + name);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(480, 840);
        frame.add(new Ataques(name));
        frame.setVisible(true);
        frame.setResizable(false);
    }


}