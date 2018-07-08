/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tile;

import Juegos.Handler;
import Juegos.Id;
import java.awt.Graphics;

/**
 *
 * @author Julio
 */
public class Flag extends Tile{

    public Flag(int x, int y, int width, int height, boolean solid, Id id, Handler handler) {
        super(x, y, width, height, solid, id, handler);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Game.flag[1].getBufferedImage(), getX(), getY(), width, 64, null);
		
	g.drawImage(Game.flag[2].getBufferedImage(), getX(), getY() + 64, width, 64, null);
	g.drawImage(Game.flag[2].getBufferedImage(), getX(), getY() + 128, width, 64, null);
	g.drawImage(Game.flag[2].getBufferedImage(), getX(), getY() + 192, width, 64, null);
		
	g.drawImage(Game.flag[0].getBufferedImage(), getX(), getY() + height-64, width, 64, null);
    }

    @Override
    public void tick() {}
    
}
