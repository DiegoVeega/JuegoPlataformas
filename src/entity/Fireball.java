package entity;

import Estados.Enemigo1;
import Juegos.Handler;
import Juegos.Id;
import Juegos.NombreJuego;
import java.awt.Graphics;
import tile.Tile;

public class Fireball extends Entity {

    public Fireball(int x, int y, int width, int height, Id id, Handler handler, int facing) {
        super(x, y, width, height, id, handler);

        switch (facing) {
            case 0:
                setVelX(-8);
                break;
            case 1:
                setVelX(8);
                break;
        }
    }

    public void render(Graphics g) {
        g.drawImage(NombreJuego.fireball.getBufferedImage(), getX(), getY(), getWidth(), getHeight(), null);
    }

    public void tick() {
        x += velX;
        y += velY;

        for (int i = 0; i < handler.tile.size(); i++) {
            Tile t = handler.tile.get(i);

            if (t.isSolid()) {
                if (getBoundsLeft().intersects(t.getBounds()) || getBoundsRight().intersects(t.getBounds())) {
                    die();
                }

                if (getBoundsBottom().intersects(t.getBounds())) {
                    jumping = true;
                    falling = false;
                    gravity = 4.0;
                } else if (!falling && !jumping) {
                    falling = true;
                    gravity = 1.0;
                }
            }
        }

        for (int i = 0; i < handler.entity.size(); i++) {
            Entity e = handler.entity.get(i);
            if (e.getId() == Id.Elenemigo1) {
                if (getBounds().intersects(e.getBounds())) {
                if (e.attackable) {
                    NombreJuego.damage.play();
                    e.hp--;
                    e.falling = true;
                    e.gravity = 3.0;
                    e.bossState = Enemigo1.RECOVERING;
                    e.attackable = false;
                    e.phaseTime = 0;

                    jumping = true;
                    falling = false;
                    gravity = 3.5;
                }
                }
            }
            if (e.getId() == Id.enemigo || e.getId() == Id.planta || e.getId() == Id.enemigo2) {
                if (getBounds().intersects(e.getBounds())) {
                    die();

                    e.die();
                }

            }
        }

    }

}
