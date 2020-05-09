package game;
import app.before.Start;
import game.entity.mob.Player;
import game.graphics.Screen;
import game.input.Keyboard;
import game.level.Level;
import game.level.TileCoordinate;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;


public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;

    public static int width = 168; // * 2
    public static int height =(1061/3);
    public static int scale = 2; // 1
    public static String title = "Camelot";

    private Thread thread;
    private JFrame frame;
    public Keyboard key;
    private Level level;
    private Player player;
    private boolean running = false;

    private Screen screen;

    private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();

    public Game() { //Constructor

        Dimension size = new Dimension(width * scale, height * scale);
        setPreferredSize(size);

        screen = new Screen(width, height);
        frame = new JFrame();
        key = new Keyboard();
        level = Level.spawn;
        //TileCoordinate playerSpawns = new TileCoordinate (20, 20);
        player = new Player(TileCoordinate.playerSpawn.x(), TileCoordinate.playerSpawn.y(), key);
        //player = new Player(playerSpawns.x(), playerSpawns.y(), key);
        player.init(level);

        addKeyListener(key);
    }


    public synchronized void start() { //star thread
        running = true;
        thread = new Thread(this, "Display"); //Display: nombre del thread.
        thread.start();
    }

    public synchronized void stop() {  //stop thread //synchronized para evitar inconcluencias en dos hilos
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    //Game loop, bucle.

    public void run() {
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / 60.0;
        double delta = 0;
        int frames = 0; //how many frames do we have to render per seccond
        int updates = 0; //gonna metre how many times this update metod is called every seccond
        requestFocus(); //para interaccionar con la pantalla nada m�s correr el juego sin necesidad de pulsar.
        while (running) { // lo mismo que poner solo while(running == true)
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                update();
                updates++;
                delta--;
            }

            render();
            frames ++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println(updates + " ups, " + frames + " fps");
                frame.setTitle(title + "  |  " + updates + " ups, " + frames + " fps"); //fps contador
                updates = 0;
                frames = 0;
            }
        }
        stop();
    }

    public void update() {

        key.update();
        player.update();

    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if(bs == null) {
            createBufferStrategy(3);
            return;
        }
        screen.clear();
        int xScroll = player.x - screen.width / 2;
        int yScroll = player.y - screen.height / 2;

        level.render(xScroll, yScroll, screen);
        player.render(screen);

        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = screen.pixels[i];
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Verdana", 0, 50));
        //g.drawString("X: " + player.x + ", Y: " + player.y, 350, 300);
        g.dispose();
        bs.show();

    }

    public static void load() {
        Game game = new Game();

        game.frame.setResizable(false);
        game.frame.setTitle(Game.title);
        game.frame.add(game); //a�adimos un componente a la ventana
        game.frame.pack(); //set the size of the frame
        game.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //terminar el proceso cuando presionas este bot�n
        game.frame.setLocationRelativeTo(Start.getFrame());
        game.frame.setLocation(1100,0);
        game.frame.setVisible(true);


        game.start();


    }

}