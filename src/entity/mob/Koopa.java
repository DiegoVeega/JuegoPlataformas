package entity.mob;

import Estados.Enemigo2;
import Juegos.Handler;
import Juegos.Id;
import entity.Entity;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import tile.Tile;
/**
import com.tutorial.mario.Handler;
import com.tutorial.mario.Id;
import com.tutorial.mario.entity.Entity;
import com.tutorial.mario.states.KoopaState;
import com.tutorial.mario.tile.Tile;
*/
public class Koopa extends Entity {
	
	private Random random;
	
	private int shellCount;

	public Koopa(int x, int y, int width, int height, Id id, Handler handler) {
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
		
		koopaState = Enemigo2.WALKING;
	}

	public void render(Graphics g) {
		if(koopaState==Enemigo2.WALKING) g.setColor(Color.GREEN);
		else g.setColor(new Color(0, 128, 0));
		
		g.fillRect(getX(),getY(),width,height);
	}

	public void tick() {
		x+=velX;
		y+=velY;
		
		if(koopaState==Enemigo2.SHELL) {
			setVelX(0);
			
			shellCount++;
			
			if(shellCount>=300) {
				shellCount = 0;
				
				koopaState = Enemigo2.WALKING;
			}
			
			if(koopaState==Enemigo2.WALKING||koopaState==Enemigo2.SPINNING) {
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
					if(koopaState==Enemigo2.SPINNING) setVelX(10);
					else setVelX(2);
				}
				
				if(getBoundsRight().intersects(t.getBounds())) {
					if(koopaState==Enemigo2.SPINNING) setVelX(-10);
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
