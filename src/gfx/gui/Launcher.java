package gfx.gui;

import Juegos.NombreJuego;
import java.awt.Color;
import java.awt.Graphics;

public class Launcher {
	
	public Button[] buttons;
	
	public Launcher() {
		buttons = new Button[2];
		
		buttons[0] = new Button(NombreJuego.getFrameWidth()/2-150,NombreJuego.getFrameHeight()/2-100,300,100,"Iniciar Juego");
		buttons[1] = new Button(NombreJuego.getFrameWidth()/2-150,NombreJuego.getFrameHeight()/2+100,300,100,"Salir del Juego");
	}
	
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, NombreJuego.getFrameWidth(), NombreJuego.getFrameHeight());
                for(int i=0;i<buttons.length;i++) {
			buttons[i].render(g);
		}
	}
}
