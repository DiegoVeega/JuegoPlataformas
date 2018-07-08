package entity.powerup;

import Juegos.Handler;
import Juegos.Id;
import entity.Entity;
import java.awt.Graphics;

public class Flower extends Entity {

	public Flower(int x, int y, int width, int height, Id id, Handler handler) {
		super(x, y, width, height, id, handler);
	}

	public void render(Graphics g) {
		g.drawImage(Game.flower.getBufferedImage(), getX(), getY(), getWidth(), getHeight(), null);
	}

	public void tick() {
		
	}

}
