package game.level.tile.old_tiles;

import game.graphics.Screen;
import game.graphics.Sprite;
import game.level.tile.Tile;

public class FlowerTile extends Tile {

    public FlowerTile(Sprite sprite) {
        super(sprite);
    }
    public void render(int x, int y, Screen screen) {
        screen.renderTile(x << 4, y << 4, this);
    }


}