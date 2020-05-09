package game.level.tile.spawn_level;

import game.graphics.Screen;
import game.graphics.Sprite;
import game.level.tile.Tile;

public class SpawnBridgeTile extends Tile {

    public SpawnBridgeTile(Sprite sprite) {
        super(sprite);
    }

    public void render(int x, int y, Screen screen) {
        screen.renderTile(x << 4, y << 4, this);
    }
    public boolean solid() {
        return true;
    }

}