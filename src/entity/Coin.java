package entity;

import Juegos.Handler;
import Juegos.Id;
import Juegos.NombreJuego;
import java.awt.Graphics;

public class Coin extends Entity {

	public Coin(int x, int y, int width, int height, Id id, Handler handler) {
		super(x, y, width, height, id, handler);
	}

	public void render(Graphics g) {
		g.drawImage(NombreJuego.coin.getBufferedImage(),x,y,width,height,null);
	}

	public void tick() {
		
	}

}
