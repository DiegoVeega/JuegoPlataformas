package entity.mob;

import Estados.Enemigo1;
import Estados.Enemigo2;
import Juegos.Handler;
import Juegos.Id;
import Juegos.NombreJuego;
import entity.Entity;
import java.awt.Graphics;
import java.util.Random;
import tile.Tile;

public class enemigo extends Entity {
	
	private Random random;
	
	private int shellCount;

	public enemigo(int x, int y, int width, int height, Id id, Handler handler) {
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
		
		goombaState = Enemigo2.WALKING;
	}

	public void render(Graphics g) {
		if(facing==0) {
			g.drawImage(NombreJuego.enemigo[4+frame].getBufferedImage(),x,y,width,height,null);
		} else if(facing==1) {
			g.drawImage(NombreJuego.enemigo[frame].getBufferedImage(),x,y,width,height,null);
		}
	}

	public void tick() {
		x+=velX;
		y+=velY;
		
		if(goombaState==Enemigo2.SHELL) {
			setVelX(0);
			
			shellCount++;
			
			if(shellCount>=300) {
				shellCount = 0;
				
				goombaState = Enemigo2.WALKING;
			}
			
			if(goombaState==Enemigo2.WALKING||goombaState==Enemigo2.SPINNING) {
				shellCount = 0;
				
				if(velX==0) {
					int dir = random.nextInt(2);
					
					switch(dir) {
					case 0:
						setVelX(-2);
						break;
					case 1:
						setVelX(2);
						break;
					}
				}
			}
		}
		
		for(int i=0;i<handler.tile.size();i++) {
			Tile t = handler.tile.get(i);
			if(t.isSolid()) {
				if(getBoundsBottom().intersects(t.getBounds())) {
					setVelY(0);
					if(falling) falling = false;
				} else if(!falling) {
					falling = true;
					gravity = 0.8;
				}
				
				if(getBoundsLeft().intersects(t.getBounds())) {
					if(goombaState==Enemigo2.SPINNING) setVelX(10);
					else setVelX(2);
				}
				
				if(getBoundsRight().intersects(t.getBounds())) {
					if(goombaState==Enemigo2.SPINNING) setVelX(-10);
					else setVelX(-2);
				}
			}
		}
		
		if(falling) {
			gravity+=0.1;
			setVelY((int)gravity);
		}
	}

}
