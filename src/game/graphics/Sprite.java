package game.graphics;

public class Sprite {

    public final int SIZE;
    private int x, y;
    public int[] pixels;
    private SpriteSheet sheet;

    public static Sprite grass = new Sprite(16, 4, 0, SpriteSheet.tiles); //null para cuando no lo usamos del todo
    public static Sprite flower = new Sprite(16, 0, 1, SpriteSheet.tiles);
    public static Sprite rock = new Sprite(16, 1, 1, SpriteSheet.tiles);
    public static Sprite voidSprite = new Sprite(16, 0);

//Spawn level Sprites:

    public static Sprite spawn_grass = new Sprite(16, 0, 0, SpriteSheet.spawn_level);
    public static Sprite spawn_grass1 = new Sprite(16, 0, 2, SpriteSheet.spawn_level);
    public static Sprite spawn_hedge = new Sprite(16, 3, 1, SpriteSheet.spawn_level);
    public static Sprite spawn_water = new Sprite(16, 3, 0, SpriteSheet.spawn_level);
    public static Sprite spawn_wall1 = new Sprite(16, 4, 0, SpriteSheet.spawn_level);
    public static Sprite spawn_wall2 = new Sprite(16, 5, 0, SpriteSheet.spawn_level);
    public static Sprite spawn_floor = new Sprite(16, 1, 2, SpriteSheet.spawn_level);
    public static Sprite spawn_bridge = new Sprite(16, 4, 1, SpriteSheet.spawn_level);
    public static Sprite spawn_carpet = new Sprite(16, 5, 1, SpriteSheet.spawn_level);

//Player Sprites:

    public static Sprite player_back = new Sprite(25, 0, 2, SpriteSheet.red_sprites);
    public static Sprite player_forward = new Sprite(25, 0, 0, SpriteSheet.red_sprites);
    public static Sprite player_side = new Sprite(25, 0, 1, SpriteSheet.red_sprites);

    public static Sprite player_forward_1 = new Sprite(25, 1, 0, SpriteSheet.red_sprites);
    public static Sprite player_forward_2 = new Sprite(25, 2, 0, SpriteSheet.red_sprites);

    public static Sprite player_side_1 = new Sprite(25, 1, 1, SpriteSheet.red_sprites);
    public static Sprite player_side_2 = new Sprite(25, 2, 1, SpriteSheet.red_sprites);

    public static Sprite player_back_1 = new Sprite(25, 1, 2, SpriteSheet.red_sprites);
    public static Sprite player_back_2 = new Sprite(25, 2, 2, SpriteSheet.red_sprites);

//red
    public static Sprite player_pokeball = new Sprite(25, 0, 3, SpriteSheet.red_sprites);
    public static Sprite player_pokeball_1 = new Sprite(25,3, 3, SpriteSheet.red_sprites);
    public static Sprite player_pokeball_2 = new Sprite(25, 1, 3, SpriteSheet.red_sprites);
    public static Sprite player_pokeball_3 = new Sprite(25, 2, 3, SpriteSheet.red_sprites);


    public static Sprite player_run_back = new Sprite(25, 3, 2, SpriteSheet.red_sprites);
    public static Sprite player_run_forward = new Sprite(25, 3, 0, SpriteSheet.red_sprites);
    public static Sprite player_run_side = new Sprite(25, 3, 1, SpriteSheet.red_sprites);

    public static Sprite player_run_forward_1 = new Sprite(25, 4, 0, SpriteSheet.red_sprites);
    public static Sprite player_run_forward_2 = new Sprite(25, 5, 0, SpriteSheet.red_sprites);

    public static Sprite player_run_side_1 = new Sprite(25, 4, 1, SpriteSheet.red_sprites);
    public static Sprite player_run_side_2 = new Sprite(25, 5, 1, SpriteSheet.red_sprites);

    public static Sprite player_run_back_1 = new Sprite(25, 4, 2, SpriteSheet.red_sprites);
    public static Sprite player_run_back_2 = new Sprite(25, 5, 2, SpriteSheet.red_sprites);

    public static Sprite player_saving_1 = new Sprite(25, 4, 3, SpriteSheet.red_sprites);
    public static Sprite player_saving_2 = new Sprite(25, 5, 3, SpriteSheet.red_sprites);



    public Sprite(int size, int x, int y, SpriteSheet sheet) {  //Constructor
        SIZE = size;
        pixels = new int[SIZE * SIZE];
        this.x = x * size;
        this.y = y * size;
        this.sheet = sheet;
        load();

    }
    public Sprite(int size, int colour) {
        SIZE = size;
        pixels = new int[SIZE * SIZE];
        setColour(colour);
    }
    private void setColour(int colour) {
        for (int i = 0; i < SIZE*SIZE; i++) {
            pixels[i] = colour;
        }


    }
    private void load() { //extracting a single sprite over every sprites.
        for (int y = 0; y <SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                pixels[x+y*SIZE] = sheet.pixels[(x + this.x) + ( y + this.y) * sheet.SIZE]; //escans every pixel in that pixel objet

            }
        }
    }
}
