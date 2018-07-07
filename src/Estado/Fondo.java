/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estado;

import Juego.PanelJuego;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author diego
 */
public class Fondo {
    
    private BufferedImage imagen;
    
    private double x;
    private double y;
    private double xx;
    private double yy;
    private double escala;
    
    public Fondo(String f) throws IOException{
        try{
        imagen=ImageIO.read(getClass().getResourceAsStream(f));
        //escala=es;
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //POSICIONAR
    public void Posicion(double x, double y){
        this.x=(x* escala) % PanelJuego.ANCHO;
        this.y=(y* escala) % PanelJuego.ALTO;
    }
    public void movimiento(double xx, double yy){
        this.xx=xx;
        this.yy=yy;
    }
    public void actualizar(){
        x+=xx;
        y+=yy;
    }
    public void dibujar(Graphics2D grafico){
        grafico.drawImage(imagen, (int)x, (int)y, null);
        if(x<0){
            grafico.drawImage(imagen, (int)x+PanelJuego.ANCHO, (int)y, null);
        }
        if(x>0){
            grafico.drawImage(imagen, (int)x-PanelJuego.ANCHO, (int)y, null);
        }
    }
    
}
