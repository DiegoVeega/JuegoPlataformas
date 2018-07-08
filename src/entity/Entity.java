package entity;

import Estados.Enemigo1;
import Estados.Enemigo2;
import Estados.EstadoJugador;
import Juegos.Handler;
import Juegos.Id;
import java.awt.Graphics;
import java.awt.Rectangle;
/**
import com.tutorial.mario.Game;
import com.tutorial.mario.Handler;
import com.tutorial.mario.Id;
import com.tutorial.mario.states.BossState;
import com.tutorial.mario.states.KoopaState;
import com.tutorial.mario.states.PlayerState;
*/
public abstract class Entity {
	
	public int x, y;
	public int width, height;
	
	public int velX, velY;
	public int frame = 0, frameDelay = 0;
	public int facing;
	public int hp;
	public int phaseTime;
	public int type;
	
	public Id id;
	
	public Enemigo1 bossState;
	public Enemigo2 koopaState;
	public EstadoJugador state;
	
	public Handler handler;
	
	public boolean jumping = false, falling = false;
	public boolean goingDownPipe = false;
	public boolean attackable = false;
	public boolean invincible = false;
	
	public double gravity = 0.0;

	public Entity(int x, int y, int width, int height, Id id, Handler handler) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.id = id;
		this.handler = handler;
	}
	
	public abstract void render(Graphics g);
	
	public abstract void tick();
	
	public void die() {
		handler.removeEntity(this);
		if(getId()==Id.jugador) {
			Game.lives--;
			Game.showDeathScreen = true;
			Game.death.play();
			
			if(Game.lives<=0) Game.gameOver = true;
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Id getId() {
		return id;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}
	
	public int getType() {
		return type;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Rectangle getBounds() {
		return new Rectangle(getX(), getY(), width, height);
	}
	
	public Rectangle getBoundsLeft() {
		return new Rectangle(getX(), getY()+10, 5, height-20);
	}
	
	public Rectangle getBoundsRight() {
		return new Rectangle(getX()+width-5, getY()+10, 5, height-20);
	}
	
	public Rectangle getBoundsTop() {
		return new Rectangle(getX()+10, getY(), width-20, 5);
	}
	
	public Rectangle getBoundsBottom() {
		return new Rectangle(getX()+10, getY()+height-5, width-20, 5);
	}
}
