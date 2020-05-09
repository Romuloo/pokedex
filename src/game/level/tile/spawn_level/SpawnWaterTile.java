package game.level.tile.spawn_level;

import game.graphics.Screen;
import game.graphics.Sprite;
import game.level.tile.Tile;

public class SpawnWaterTile extends Tile {

    public SpawnWaterTile(Sprite sprite) {
        super(sprite);
    }
    public void render(int x, int y, Screen screen) {
        screen.renderTile(x << 4, y << 4, this);
    }
    public boolean solid() {
        return true;
    }
}
