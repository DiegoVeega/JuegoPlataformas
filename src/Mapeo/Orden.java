/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapeo;

import java.awt.image.BufferedImage;

/**
 *
 * @author diego
 */
public class Orden {
    private BufferedImage imagen;
    private int tipo;
    
    public static final int NORMAL=0;
    public static final int BLOQUEADO=1;
    
    public Orden(BufferedImage imagen, int tipo){
     this.imagen=imagen;
     this.tipo=tipo;
    }
    public BufferedImage getImage(){
        return imagen;
    }
    public int getTipo(){
        return tipo;
    }
}
