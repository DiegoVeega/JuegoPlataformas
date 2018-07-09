package gfx.gui;

import Juegos.NombreJuego;
import java.awt.Color;
import java.awt.Graphics;

//import com.tutorial.mario.Game;

public class Launcher {
	
	public Button[] buttons;
	
	public Launcher() {
		buttons = new Button[2];
		
		buttons[0] = new Button(NombreJuego.getFrameWidth()/2-150,NombreJuego.getFrameHeight()/2-100,300,100,"Iniciar ");
		buttons[1] = new Button(NombreJuego.getFrameWidth()/2-150,NombreJuego.getFrameHeight()/2+100,300,100,"Abandonar ");
	}
	
	public void render(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, NombreJuego.getFrameWidth(), NombreJuego.getFrameHeight());
		
		for(int i=0;i<buttons.length;i++) {
			buttons[i].render(g);
		}
	}

}
