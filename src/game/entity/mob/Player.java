package game.entity.mob;

import game.graphics.Screen;
import game.graphics.Sprite;
import game.input.Keyboard;

public class Player extends Mob {

    private Keyboard input;
    private Sprite sprite;
    private int anim = 0;
    private boolean walking = false;

    private int anime = 0;

    private int savAnim = 0;

    public Player(Keyboard input) { //�No sirve para nada?
        this.input = input;
        sprite = Sprite.player_forward;
    }

    public Player(int x, int y, Keyboard input) {
        this.x = x;
        this.y = y;
        this.input = input;
        sprite = Sprite.player_forward;
    }
    //movimiento

    public void update() {

        if (input.running) {
            int xa = 0, ya = 0;
            if (anim < 7500) anim++;
            else anim = 0;
            if (input.up && !input.left && !input.right) ya -= 1;
            if (input.down && !input.left && !input.right) ya += 1;
            if (input.left) xa -= 1;
            if (input.right) xa += 1;

            if (xa != 0 || ya != 0) {
                move(xa, 0);
                move(0, ya);
                walking = true;
            }
        }

        if(input.pokeball && !walking) anime ++;
        if(!input.pokeball | walking) anime = 0;   //animaci�n pokeball.

        if(input.saving && !walking) savAnim ++;
        if(!input.saving | walking) savAnim = 0; //anim saving

        int xa = 0, ya = 0;
        if (anim < 7500) anim++;
        else anim = 0;
        if(input.down && !input.left && !input.right) ya++;
        if (input.up && !input.left && !input.right) ya--;

        if (input.left  )xa--;

        if (input.right )xa++;


        if (xa != 0 || ya != 0) {
            move(xa, 0);
            move(0, ya);
            walking = true;
        } else {
            walking = false;
        }


    }
    //movimiento con animaciones
    public void render(Screen screen) {

        if (input.running) {


            int flip = 0;
            if (dir == 0) {
                sprite = Sprite.player_forward;
                if (walking) {
                    if (anim % 60 > 30) {
                        sprite = Sprite.player_run_forward_1;
                    } else {
                        sprite = Sprite.player_run_forward_2;
                    }
                }
            }
            if (dir == 2) {
                sprite = Sprite.player_back;
                if (walking) {
                    if ((anim % 120 >= 80)) {
                        sprite = Sprite.player_run_back_1;
                    }
                    if ((anim % 120 >= 40) && (anim % 120 < 80)) {
                        sprite = Sprite.player_run_back;
                    }

                    if ((anim % 120 >= 0) && (anim % 120 < 40)) {
                        sprite = Sprite.player_run_back_2;
                    }
                }
            }
            if (dir == 1) {
                sprite = Sprite.player_run_side;
                if (walking) {
                    if ((anim % 60 >= 40)) {
                        sprite = Sprite.player_run_side_1;
                    }
                    if ((anim % 60 >= 20) && (anim % 60 < 40)) {
                        sprite = Sprite.player_run_side;
                    }

                    if ((anim % 60 >= 0) && (anim % 60 < 20)) {
                        sprite = Sprite.player_run_side_2;
                    }
                }
            }
            if (dir == 3) {
                sprite = Sprite.player_side;
                if (walking) {
                    if ((anim % 60 >= 40)) {
                        sprite = Sprite.player_run_side_1;
                    }
                    if ((anim % 60 >= 20) && (anim % 60 < 40)) {
                        sprite = Sprite.player_run_side;
                    }

                    if ((anim % 60 >= 0) && (anim % 60 < 20)) {
                        sprite = Sprite.player_run_side_2;
                    }
                }
                flip = 1;
            }
            screen.renderPlayer(x - 16, y - 16, sprite, flip);

        } else if (input.saving) {
            int flip = 0;
            if (dir == 0) {
                if (!walking) {
                    if (savAnim < 22 * 4) {
                        sprite = Sprite.player_saving_2;
                    }
                    if (savAnim > 22 * 4) {
                        sprite = Sprite.player_saving_1;
                    }
                    if (savAnim > 26 * 4) {
                        sprite = Sprite.player_forward;
                    }


                } else if (walking) {
                    if (anim % 20 > 10) {
                        sprite = Sprite.player_forward_1;
                    } else {
                        sprite = Sprite.player_forward_2;
                    }
                }
            }
            if (dir == 2) {
                sprite = Sprite.player_back;
                if (walking) {
                    if (anim % 20 > 10) {
                        sprite = Sprite.player_back_1;
                    } else {
                        sprite = Sprite.player_back_2;
                    }
                }
            }
            if (dir == 1) {
                sprite = Sprite.player_side;
                if (walking) {
                    if (anim % 20 > 10) {
                        sprite = Sprite.player_side_1;
                    } else {
                        sprite = Sprite.player_side_2;
                    }
                }
            }
            if (dir == 3) {
                sprite = Sprite.player_side;
                if (walking) {
                    if (anim % 20 > 10) {
                        sprite = Sprite.player_side_1;
                    } else {
                        sprite = Sprite.player_side_2;
                    }
                }
                flip = 1;
            }


            screen.renderPlayer(x - 16, y - 16, sprite, flip);
        } else if (input.pokeball) {

            int flip = 0;
            if (dir == 0) {
                if (!walking) {
                    if ((anime < 16 * 4) && (anime > 12 * 4)) {
                        sprite = Sprite.player_pokeball;
                    }
                    if ((anime < 12 * 4) && (anime > 8 * 4)) {
                        sprite = Sprite.player_pokeball_3;
                    }
                    if ((anime < 8 * 4) && (anime > 4 * 4)) {
                        sprite = Sprite.player_pokeball_2;
                    }
                    if ((anime < 4 * 4)) {
                        sprite = Sprite.player_pokeball_1;
                    }
                    if (sprite == Sprite.player_pokeball) anime = 20 * 4;
                } else if (walking) {
                    if (anim % 20 > 10) {
                        sprite = Sprite.player_forward_1;
                    } else {
                        sprite = Sprite.player_forward_2;
                    }
                }
            }
            if (dir == 2) {
                sprite = Sprite.player_back;
                if (walking) {
                    if (anim % 20 > 10) {
                        sprite = Sprite.player_back_1;
                    } else {
                        sprite = Sprite.player_back_2;
                    }
                }
            }
            if (dir == 1) {
                sprite = Sprite.player_side;
                if (walking) {
                    if (anim % 20 > 10) {
                        sprite = Sprite.player_side_1;
                    } else {
                        sprite = Sprite.player_side_2;
                    }
                }
            }
            if (dir == 3) {
                sprite = Sprite.player_side;
                if (walking) {
                    if (anim % 20 > 10) {
                        sprite = Sprite.player_side_1;
                    } else {
                        sprite = Sprite.player_side_2;
                    }
                }
                flip = 1;
            }
            screen.renderPlayer(x - 16, y - 16, sprite, flip);


        } else {

            int flip = 0;
            if (dir == 0) {
                sprite = Sprite.player_forward;
                if (walking) {
                    if (anim % 20 > 10) {
                        sprite = Sprite.player_forward_1;
                    } else {
                        sprite = Sprite.player_forward_2;
                    }
                }
            }
            if (dir == 2) {
                sprite = Sprite.player_back;
                if (walking) {
                    if (anim % 20 > 10) {
                        sprite = Sprite.player_back_1;
                    } else {
                        sprite = Sprite.player_back_2;
                    }
                }
            }
            if (dir == 1) {
                sprite = Sprite.player_side;
                if (walking) {
                    if (anim % 20 > 10) {
                        sprite = Sprite.player_side_1;
                    } else {
                        sprite = Sprite.player_side_2;
                    }
                }
            }
            if (dir == 3) {
                sprite = Sprite.player_side;
                if (walking) {
                    if (anim % 20 > 10) {
                        sprite = Sprite.player_side_1;
                    } else {
                        sprite = Sprite.player_side_2;
                    }
                }
                flip = 1;
            }
            screen.renderPlayer(x - 16, y - 16, sprite, flip);

        }
    }
}