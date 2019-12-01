package domain.ataques;


import domain.stats.BarGraph;
import domain.stats.BarGraphModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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


    private synchronized static void createFrame(){
        if(frame == null)
            frame = new JFrame();
        frame.setLocationRelativeTo(null);
        frame.setLocation(1000,1000);
    }

    private static JFrame getFrame(){
        if(frame == null)  createFrame();
        return frame;

    }



    public static void ataques(String path, String name) {
        thisPath = path;
        thisName = name;
        JFrame frame = getFrame();
        frame.setTitle("Ataques de " + name);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(480, 840);
        frame.add(new Ataques(path, name));
        frame.setVisible(true);
        frame.setResizable(false);
    }


}
