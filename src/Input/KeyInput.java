/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorial.mario.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.tutorial.mario.Game;
import com.tutorial.mario.Id;
import com.tutorial.mario.entity.Entity;
import com.tutorial.mario.entity.Fireball;
import com.tutorial.mario.states.PlayerState;
import com.tutorial.mario.tile.Tile;

/**
 *
 * @author Rafael Melara
 */

public class KeyInput implements KeyListener {
	
	private boolean fire;
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		for(int i=0;i<Game.handler.entity.size();i++) {
			Entity en = Game.handler.entity.get(i);
			if(en.getId()==Id.player) {
				if(en.goingDownPipe) return;
				switch(key) {
				case KeyEvent.VK_W:
					for(int q=0;q<Game.handler.tile.size();q++) {
						Tile t = Game.handler.tile.get(q);
						if(t.isSolid()) {
							if(en.getBoundsBottom().intersects(t.getBounds())) {
								if(!en.jumping) {
									en.jumping = true;
									en.gravity = 11.0;
									Game.jump.play();
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
					for(int q=0;q<Game.handler.tile.size();q++) {
						Tile t = Game.handler.tile.get(q);
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
					if(en.state==PlayerState.FIRE&&!fire) {
						switch(en.facing) {
						case 0:
							Game.handler.addEntity(new Fireball(en.getX()-24,en.getY()+12,24,24,Id.fireball,Game.handler,en.facing));
							fire = true;
							break;
						case 1:
							Game.handler.addEntity(new Fireball(en.getX()+en.getWidth(),en.getY()+12,24,24,Id.fireball,Game.handler,en.facing));
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
		for(int i=0;i<Game.handler.entity.size();i++) {
			Entity en = Game.handler.entity.get(i);
			if(en.getId()==Id.player) {
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
