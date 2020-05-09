package game.level.tile;

import game.graphics.Screen;
import game.graphics.Sprite;
import game.level.tile.old_tiles.FlowerTile;
import game.level.tile.old_tiles.GrassTile;
import game.level.tile.old_tiles.RockTile;
import game.level.tile.spawn_level.*;

public class Tile {

    public int x, y;
    public Sprite sprite;

    //old tiles
    public static Tile grass = new GrassTile(Sprite.grass);
    public static Tile flower = new FlowerTile(Sprite.flower);
    public static Tile rock = new RockTile(Sprite.rock);


    public static Tile voidTile = new VoidTile(Sprite.voidSprite);

    public static Tile spawn_grass = new SpawnGrassTile(Sprite.spawn_grass);
    public static Tile spawn_grass1 = new SpawnGrassTile(Sprite.spawn_grass1);
    public static Tile spawn_hedge = new SpawnHedgeTile(Sprite.spawn_hedge);
    public static Tile spawn_water = new SpawnWaterTile(Sprite.spawn_water);
    public static Tile spawn_wall1 = new SpawnWallTile(Sprite.spawn_wall1);
    public static Tile spawn_wall2 = new SpawnWallTile(Sprite.spawn_wall2);
    public static Tile spawn_floor = new SpawnFloorTile(Sprite.spawn_floor);
    public static Tile spawn_bridge = new SpawnBridgeTile(Sprite.spawn_bridge);
    public static Tile spawn_carpet = new SpawnCarpetTile(Sprite.spawn_carpet);

    public final static int col_spawn_grass = 0xff00ff00;
    public final static int col_spawn_grass1 = 0xff00e400;
    public final static int col_spawn_hedge = 0xff7f7f00;
    public final static int col_spawn_water = 0xff0026ff;
    public final static int col_spawn_wall1 = 0xff808080;
    public final static int col_spawn_wall2 = 0xff303030;
    public static final int col_spawn_floor = 0xff824900;
    public static final int col_spawn_bridge = 0xff00ffff;
    public static final int col_spawn_carpet = 0xffff0000;

    public Tile(Sprite sprite) {
        this.sprite = sprite;
    }

    public void render(int x, int y, Screen screen) {
    }

    public boolean solid() {
        return false;
    }


}
