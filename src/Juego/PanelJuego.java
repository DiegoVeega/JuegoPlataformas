/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import Estado.ControladorEstados;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author diego
 */
public class PanelJuego extends JPanel implements Runnable, KeyListener{
    public static final int ANCHO=1800;
    public static final int ALTO=900;
    
    private Thread hilo;
    private boolean correr;
    //IMAGENES
    private BufferedImage imagen;
    private Graphics2D grafico;
    
    //CONTROLADOR
    private ControladorEstados cde;
    
    public PanelJuego(){
        super();
        setPreferredSize(new Dimension(ANCHO, ALTO));
        setFocusable(true);
        requestFocus();
    }
    public void addNotify(){
        super.addNotify();
        if(hilo==null){
            hilo=new Thread(this);
            addKeyListener(this);
            hilo.start();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //AL PRESIONAR
    @Override
    public void keyPressed(KeyEvent e) {
        cde.presion(e.getKeyCode());
    }
    //AL SELECCIONAR
    @Override
    public void keyReleased(KeyEvent e) {
        cde.seleccion(e.getKeyCode());
    }

    private void iniciar(){
        imagen=new BufferedImage(ANCHO, ALTO,BufferedImage.TYPE_INT_RGB);
        grafico=(Graphics2D) imagen.getGraphics();
        correr=true;
        cde= new ControladorEstados();
    }
    
    @Override
    public void run() {
        iniciar(); 
        while(correr==true){
            actualizar();
            colocar();
            mostar();
        }
    }

    private void actualizar() {
        cde.actualizar();
    }

    private void colocar() {
        cde.dibujar(grafico);
    }
    
    private void mostar() {
        Graphics g= getGraphics();
        g.drawImage(imagen, 0, 0, ANCHO*4, ALTO*5,null);
        g.dispose();
    }
}