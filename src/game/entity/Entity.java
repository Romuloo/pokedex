package game.entity;

import game.graphics.Screen;
import game.level.Level;

import java.util.Random;

public abstract class Entity {

    public int x, y;
    private boolean removed = false;
    protected Level level;
    protected final Random random = new Random();

    public void update() {
    }

    public void render(Screen screen) {
    }

    public void remove() {
        removed = true; //Remove from level
    }

    public boolean isRemoved() {
        return removed;
    }
    public void init(Level level) { //init == inicializar
        this.level = level;
    }
}
