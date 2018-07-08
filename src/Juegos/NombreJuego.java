/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juegos;

import java.awt.Dimension;
import java.awt.Canvas;
import javax.swing.JFrame;

/**
 *
 * @author diego
 */
public class NombreJuego extends Canvas{
    public static final int ANCHO=270;
    public static final int ALTO= ANCHO/14*10;
    public static final int ESCALA=4;

    public NombreJuego() {
        Dimension tamanio=new Dimension(ANCHO*ESCALA,ALTO*ESCALA);
        setPreferredSize(tamanio);
    }
    
    public static void main(String[] args){
        NombreJuego juego=new NombreJuego();
        JFrame vista = new JFrame("Hola soy el Juego");
        vista.add(juego);
        vista.pack();
        vista.setResizable(false);
        vista.setLocationRelativeTo(null);
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setVisible(true);
    }
    
}
