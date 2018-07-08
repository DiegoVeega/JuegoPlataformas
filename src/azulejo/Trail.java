/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package azulejo;

import Juegos.Handler;
import Juegos.Id;
import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author Julio
 */
public class Trail extends Tile{
    
    private BufferedImage image;
    
    private float alpha = 0.8f;

    public Trail(int x, int y, int width, int height, boolean solid, Id id, Handler handler, BufferedImage image) {
        super(x, y, width, height, solid, id, handler);
        this.image = image;
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
		
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
		g.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);
    }

    @Override
    public void tick() {
        alpha-=0.05f;
		
	if(alpha<0.08) die();
    }
    
}
