package entity.powerup;

import Juegos.Handler;
import Juegos.Id;
import Juegos.NombreJuego;
import entity.Entity;
import java.awt.Graphics;
import java.util.Random;
import tile.Tile;

public class PowerStar extends Entity {
	
	private Random random;

	public PowerStar(int x, int y, int width, int height, Id id, Handler handler) {
		super(x, y, width, height, id, handler);
		random = new Random();
		
		int dir = random.nextInt(2);
		
		switch(dir) {
		case 0:
			setVelX(-2);
			break;
		case 1:
			setVelX(2);
			break;
		}
		
		falling = true;
		gravity = 0.8;
	}

	public void render(Graphics g) {
		g.drawImage(NombreJuego.star.getBufferedImage(), getX(), getY(), getWidth(), getHeight(), null);
	}

	public void tick() {
		x+=velX;
		y+=velY;
		
		for(int i=0;i<handler.tile.size();i++) {
			Tile t = handler.tile.get(i);
			
			if(t.isSolid()) {
				if(getBoundsBottom().intersects(t.getBounds())) {
					jumping = true;
					falling = false;
					gravity = 8.0;
				}

				if(getBoundsLeft().intersects(t.getBounds())) setVelX(2);
				if(getBoundsRight().intersects(t.getBounds())) setVelX(-2);
			}
		}
		
		if(jumping) {
			gravity-=0.17;
			setVelY((int)-gravity);
			if(gravity<=0.5) {
				jumping = false;
				falling = true;
			}
		}	
		
		if(falling) {
			gravity+=0.17;
			setVelY((int)gravity);
		}
	}

}
