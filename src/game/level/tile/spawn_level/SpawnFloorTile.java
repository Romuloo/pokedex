package game.level.tile.spawn_level;

import game.graphics.Screen;
import game.graphics.Sprite;
import game.level.tile.Tile;

public class SpawnFloorTile extends Tile {

    public SpawnFloorTile(Sprite sprite) {
        super(sprite);
    }
    public void render(int x, int y, Screen screen) {
        screen.renderTile(x << 4, y << 4, this);
    }

}