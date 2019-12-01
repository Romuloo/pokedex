package domain.ataques;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author Javier Linares Castrillon
 */

public class Ataques extends JPanel {



    private static String thisName;
    private static String thisPath;
    private static JFrame frame;

    private DefaultListModel modelo = new DefaultListModel();
    private JList<String> list = new JList<String>();
    private JScrollPane s = new JScrollPane(list);

    private ImageIcon image = new ImageIcon(thisPath);
    private Font f = new Font("Calibri", Font.BOLD, 26);




    private ArrayList<String> ataques(){

        ArrayList<String> ataques = new ArrayList<>();

        for(int i = 0; i <100; i++) ataques.add(" i " + i + " i");
        return ataques;
    }

    public Ataques(String path, String name) {
        setLayout(null);
        this.thisPath = path;
        this.thisName = name;
        setBackground(new Color(146, 207, 138));
        initList();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image.getImage(),40 ,50,400,400,null);
        g.setFont(f);
        g.setColor(Color.darkGray);
        g.drawString(thisName, 180, 30);

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
        s.setBounds(5,440,470,340);
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


    public static void ataques(String path, String name) {

        frameManager();
        frame.setLocationRelativeTo(null);
        frame.setLocation(1000,1000);
        frame.setTitle("Ataques de " + name);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        thisPath = path;
        thisName = name;
        frame.setSize(480, 840);
        frame.add(new Ataques(path, name));
        frame.setVisible(true);
        frame.setResizable(false);
    }


}
