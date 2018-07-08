/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tile;

import Juegos.Handler;
import Juegos.Id;
import Juegos.NombreJuego;
import entity.powerup.Flower;
import entity.powerup.Mushroom;
import gfx.Sprite;
import java.awt.Graphics;

/**
 *
 * @author Julio
 */
public class PowerUpBlock extends Tile {
	
	private Sprite powerUp;
	
	private boolean poppedUp = false;
	
	private int spriteY = getY();
	private int type;

	public PowerUpBlock(int x, int y, int width, int height, boolean solid, Id id, Handler handler, Sprite powerUp, int type) {
		super(x, y, width, height, solid, id, handler);
		this.type = type;
		this.powerUp = powerUp;
	}

	public void render(Graphics g) {
		if(!poppedUp) g.drawImage(powerUp.getBufferedImage(),x,spriteY,width,height,null);
		if(!activated) g.drawImage(NombreJuego.powerUp.getBufferedImage(),x,y,width,height,null);
		else g.drawImage(NombreJuego.usedPowerUp.getBufferedImage(),x,y,width,height,null);
	}

	public void tick() {
		if(activated&&!poppedUp) {
			spriteY--;
			if(spriteY<=y-height) {
				if(powerUp==NombreJuego.mushroom||powerUp==NombreJuego.lifeMushroom) handler.addEntity(new Mushroom(x,spriteY,width,height,Id.hongo,handler,type));
				else if(powerUp==NombreJuego.flower) handler.addEntity(new Flower(x,spriteY,width,height,Id.flor,handler));
				poppedUp = true;
			}
		}
	}

}
