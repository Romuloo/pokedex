package game.graphics;

import game.level.tile.Tile;

import java.util.Random;

public class Screen {

    public int width, height;
    public int[] pixels;
    public final int MAP_SIZE = 64;
    public final int MAP_SIZE_MASK = MAP_SIZE - 1;
    public int xOffset, yOffset;
    public int[] tiles = new int[MAP_SIZE * MAP_SIZE];

    private Random random = new Random();

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new int[width * height];

        for ( int i = 0; i < MAP_SIZE * MAP_SIZE; i++) {
            tiles[i] = random.nextInt(0xffffff);
            tiles[0] = 0;
        }

    }

    public void clear() {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }


    public void renderTile(int xp, int yp, Tile tile) {
        xp -= xOffset;
        yp -= yOffset;
        for (int y = 0; y < tile.sprite.SIZE; y++) {//absolute/relative positions
            int ya = y + yp;
            for (int x = 0; x < tile.sprite.SIZE; x++) {//absolute/relative positions
                int xa = x + xp;
                if (xa < -tile.sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
                if (xa < 0) xa = 0;
                pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
            }
        }
    }
    public void renderPlayer(int xp, int yp, Sprite sprite, int flip) {
        xp -= xOffset;
        yp -= yOffset;
        for (int y = 0; y < sprite.SIZE; y++) {   //sprite.SIZE replaza a 32, sprite.size - 1 a 31. (rendering a 25 * 25 skin)
            int ya = y + yp;
            int ys = y;
            if (flip == 2 || flip == 3) ys = (sprite.SIZE - 1) - y;
            for (int x = 0; x < sprite.SIZE; x++) {
                int xa = x + xp;
                int xs = x;
                if (flip == 1 || flip == 3) xs = (sprite.SIZE - 1) - x;
                if (xa < -sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
                if (xa < 0) xa = 0;
                int col = sprite.pixels[xs + ys * sprite.SIZE];
                if (col != 0xffff00ff) pixels[xa + ya * width] = col;
            }
        }
    }

    public void setOffset(int xOffset, int yOffset) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }
}
