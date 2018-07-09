/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juegos;

import entity.Coin;
import entity.Entity;
import entity.mob.enemigo;
import entity.mob.enemigo2;
import entity.mob.Player;
import entity.mob.TowerBoss;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import tile.Flag;
import tile.Pipe;
import tile.PowerUpBlock;
import tile.Tile;
import tile.Wall;

/**
 *
 * @author diego
 */
public class Handler {

    public LinkedList<Entity> entity = new LinkedList<Entity>();
    public LinkedList<Tile> tile = new LinkedList<Tile>();

    public void render(Graphics g) {
        for (int i = 0; i < entity.size(); i++) {
            Entity e = entity.get(i);
            if (NombreJuego.getVisibleArea() != null && e.getBounds().intersects(NombreJuego.getVisibleArea()) && e.getId() != Id.particula) {
                e.render(g);
            }
        }

        for (int i = 0; i < tile.size(); i++) {
            Tile t = tile.get(i);
            if (NombreJuego.getVisibleArea() != null && t.getBounds().intersects(NombreJuego.getVisibleArea())) {
                t.render(g);
            }
        }

        for (int i = 0; i < entity.size(); i++) {
            Entity e = entity.get(i);
            if (NombreJuego.getVisibleArea() != null && e.getBounds().intersects(NombreJuego.getVisibleArea()) && e.getId() == Id.particula) {
                e.render(g);
            }
        }

        g.drawImage(NombreJuego.coin.getBufferedImage(), NombreJuego.getVisibleArea().x + 20, NombreJuego.getVisibleArea().y + 20, 75, 75, null);
        g.drawImage(NombreJuego.lifeMushroom.getBufferedImage(), NombreJuego.getVisibleArea().x + 20, NombreJuego.getVisibleArea().y + 100, 75, 75, null);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Fixedsys", Font.BOLD, 20));
        g.drawString("x " + NombreJuego.coins, NombreJuego.getVisibleArea().x + 100, NombreJuego.getVisibleArea().y + 95);
        g.drawString("x" + NombreJuego.lives, NombreJuego.getVisibleArea().x + 100, NombreJuego.getVisibleArea().y + 175);
    }

    public void tick() {
        for (int i = 0; i < entity.size(); i++) {
            Entity e = entity.get(i);
            e.tick();
        }

        for (int i = 0; i < tile.size(); i++) {
            Tile t = tile.get(i);
            if (NombreJuego.getVisibleArea() != null && t.getBounds().intersects(NombreJuego.getVisibleArea())) {
                t.tick();
            }
        }
    }

    public void addEntity(Entity e) {
        entity.add(e);
    }

    public void removeEntity(Entity e) {
        entity.remove(e);
    }

    public void addTile(Tile t) {
        tile.add(t);
    }

    public void removeTile(Tile t) {
        tile.remove(t);
    }

    public void createLevel(BufferedImage level) {
        int width = level.getWidth();
        int height = level.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = (int) level.getRGB(x, y);

                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;

                if (red == 0 && green == 0 && blue == 0) {
                    addTile(new Wall(x * 64, y * 64, 64, 64, true, Id.pared, this));
                }
                if (red == 0 && green == 0 && blue == 255) {
                    addEntity(new Player(x * 64, y * 64, 48, 48, Id.jugador, this));
                }
                if (red == 0 & green == 0 & blue == 155) {
                    addEntity(new enemigo(x * 64, y * 64, 64, 64, Id.enemigo2, this));
                }
                if (red == 255 & green == 0 & blue == 0) {
                    addEntity(new enemigo2(x * 64, y * 64, 64, 64, Id.enemigo2, this));
                }
                if (red == 70 & green == 0 & blue == 0) {
                    addEntity(new TowerBoss(x * 64, y * 64, 64, 64, Id.Elenemigo1, this,3));
                }
                if (red == 0 && (green >= 125 && green <= 128) && blue == 0) {
                    addTile(new Pipe(x * 64, y * 64, 64, 64 * 15, true, Id.pipe, this, 128 - green, true));
                }
                if (red == 255 && green == 255 && blue == 0) {
                    addEntity(new Coin(x * 64, y * 64, 64, 64, Id.moneda, this));
                }
                if (red == 255 & green == 128 && blue == 0) {
                    addTile(new PowerUpBlock(x * 64, y * 64, 64, 64, true, Id.powerUp, this, NombreJuego.flower, 0));
                }
                if (red == 0 & green == 255 && blue == 0) {
                    addTile(new Flag(x * 64, y * 64, 64, 64 * 5, true, Id.bandera, this));
                }
            }
        }

        NombreJuego.deathY = NombreJuego.getDeathY();
    }

    public void clearLevel() {
        entity.clear();
        tile.clear();
    }

}
