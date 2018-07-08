/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package azulejo;

import Juegos.Handler;
import Juegos.Id;
import java.awt.Graphics;

/**
 *
 * @author Julio
 */
public class PowerUpBlock extends Tile{
    
    private Sprite powerUp;
	
    private boolean poppedUp = false;
    private int spriteY = getY();
    private int type;

    public PowerUpBlock(int x, int y, int width, int height, boolean solid, Id id, Handler handler) {
        super(x, y, width, height, solid, id, handler);
        this.type = type;
	this.powerUp = powerUp;
    }

    @Override
    public void render(Graphics g) {
        if(!poppedUp) g.drawImage(powerUp.getBufferedImage(),x,spriteY,width,height,null);
	if(!activated) g.drawImage(Game.powerUp.getBufferedImage(),x,y,width,height,null);
	else g.drawImage(Game.usedPowerUp.getBufferedImage(),x,y,width,height,null);
    }

    @Override
    public void tick() {
        if(activated&&!poppedUp) {
			spriteY--;
			if(spriteY<=y-height) {
				if(powerUp==Game.mushroom||powerUp==Game.lifeMushroom) handler.addEntity(new Mushroom(x,spriteY,width,height,Id.mushroom,handler,type));
				else if(powerUp==Game.flower) handler.addEntity(new Flower(x,spriteY,width,height,Id.flower,handler));
				poppedUp = true;
			}
		}
	}
    }
    
}
