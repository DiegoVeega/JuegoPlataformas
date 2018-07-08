/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Input;

import Estados.EstadoJugador;
import Juegos.Id;
import Juegos.NombreJuego;
import entity.Entity;
import entity.Fireball;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import tile.Tile;


/**
 *
 * @author Rafael Melara
 */

public class KeyInput implements KeyListener {
	
	private boolean fire;
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		for(int i=0;i<NombreJuego.handler.entity.size();i++) {
			Entity en = NombreJuego.handler.entity.get(i);
			if(en.getId()==Id.jugador) {
				if(en.goingDownPipe) return;
				switch(key) {
				case KeyEvent.VK_W:
					for(int q=0;q<NombreJuego.handler.tile.size();q++) {
						Tile t = NombreJuego.handler.tile.get(q);
						if(t.isSolid()) {
							if(en.getBoundsBottom().intersects(t.getBounds())) {
								if(!en.jumping) {
									en.jumping = true;
									en.gravity = 11.0;
									NombreJuego.jump.play();
								}
							} else if(t.getId()==Id.pipe) {
								if(en.getBoundsTop().intersects(t.getBounds())) {
									if(!en.goingDownPipe) en.goingDownPipe = true;
								}
							}
						}
					}
					break;
				case KeyEvent.VK_S:
					for(int q=0;q<NombreJuego.handler.tile.size();q++) {
						Tile t = NombreJuego.handler.tile.get(q);
						if(t.getId()==Id.pipe) {
							if(en.getBoundsBottom().intersects(t.getBounds())) {
								if(!en.goingDownPipe) en.goingDownPipe = true;
							}
						}
					}
					break;
				case KeyEvent.VK_A:
					en.setVelX(-5);
					en.facing = 0;
					break;
				case KeyEvent.VK_D:
					en.setVelX(5);
					en.facing = 1;
					break;
				case KeyEvent.VK_SPACE:
					if(en.state==EstadoJugador.FIRE&&!fire) {
						switch(en.facing) {
						case 0:
							NombreJuego.handler.addEntity(new Fireball(en.getX()-24,en.getY()+12,24,24,Id.bolafuego,NombreJuego.handler,en.facing));
							fire = true;
							break;
						case 1:
							NombreJuego.handler.addEntity(new Fireball(en.getX()+en.getWidth(),en.getY()+12,24,24,Id.bolafuego,NombreJuego.handler,en.facing));
							fire = true;
							break;
						}
					}
				}
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for(int i=0;i<NombreJuego.handler.entity.size();i++) {
			Entity en = NombreJuego.handler.entity.get(i);
			if(en.getId()==Id.jugador) {
				switch(key) {
				case KeyEvent.VK_W:
					en.setVelY(0);
					break;
				case KeyEvent.VK_A:
					en.setVelX(0);
					break;
				case KeyEvent.VK_D:
					en.setVelX(0);
					break;
				case KeyEvent.VK_SPACE:
					fire = false;
					break;
				}
			}
		}
	}

	public void keyTyped(KeyEvent e) {
		
	}
	
}
