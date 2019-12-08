package app.before;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase previa encargada de mostrar la página de inicio.
 */
public class Begin extends JPanel{

    private static JFrame main = new JFrame();
    private JButton start = new JButton();

    /**
     * Construye un panel con sus componentes.
     */
    public Begin(){
        setLayout(null);
        initComponents();
    }

    /**
     * Pinta el fondo del panel.
     * @param g
     */
    public void paint(Graphics g){
        Dimension height = getSize();
        ImageIcon Img = new ImageIcon("res/imagenes/pokedex.png");
        g.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);


        setOpaque(false);
        super.paint(g);
    }

    private void initComponents(){
        start.setBounds(10,(2846/4)/2+4, 60,60 );
        start.setVisible(true);
        start.setOpaque(true);
        start.setContentAreaFilled(false);
        start.setBorderPainted(false);
        start.setBorder(null);

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               begin();
            }
        });
        add(start);
    }

    private void begin(){
        main.dispose();
        Start.start();
    }

    /**
     * Inicializa el frame del principio.
     */
    public static void init(){

        main.setTitle("Pokedex");
        main.setVisible(true);
        main.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        main.setLocation(200,40);
        main.setResizable(false);
        main.setSize(1600/4, 2846/4);
        main.add(new Begin());

    }



}
