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
public class Wall extends Tile{

    public Wall(int x, int y, int width, int height, boolean solid, Id id, Handler handler) {
        super(x, y, width, height, solid, id, handler);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Game.grass.getBufferedImage(),x,y,width,height,null);
    }

    @Override
    public void tick() {
        
    }
    
}
