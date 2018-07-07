/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estado;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */

public class Menu extends Estado{
    
    //FONDO MENU
    private Fondo f;
    
    private Color color;
    private Font fuente;
    
    private Font fuenteop;
    
    private int OpcionActual=0;
    private String[] eleccion ={
        "INICIAR",
        "AYUDA",
        "SALIR"
    };
    
    public Menu(ControladorEstados cde) {
        this.cde=cde;
        try {
            f=new Fondo("/RECURSOS/fonTemp.gif");
            f.movimiento(-0.1, 0);
            color=new Color(222,254,61);
            fuente=new Font("Fixedsys", Font.BOLD ,25);
            fuenteop=new Font("Fixedsys", Font.BOLD ,10);
            
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void iniciar() {
    }

    @Override
    public void actualizar() {
        f.actualizar();
    }
    
    public void ELEC(){
        switch(OpcionActual){
            case 0:
                break;
            case 1:
                break;
            case 2:
                System.exit(0);
        }
    }
    
    @Override
    public void presion(int t) {
        if( t== KeyEvent.VK_ENTER){
            ELEC();
        }
        if( t== KeyEvent.VK_UP){
            OpcionActual--;
            if(OpcionActual==-1){
                OpcionActual=eleccion.length -1;
            }
        }
        if( t== KeyEvent.VK_DOWN){
            OpcionActual++;
            if(OpcionActual==eleccion.length){
                OpcionActual=0;
            }
        }
    }

    @Override
    public void seleccion(int t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dibujar(Graphics2D grafico) {
        f.dibujar(grafico);
        grafico.setColor(color);
        grafico.setFont(fuente);
        grafico.drawString("HOLA SOY EL JUEGO", 95, 70);
        //OPCIONES
        grafico.setFont(fuenteop);
        for (int i = 0; i < eleccion.length; i++) {
            if(i==OpcionActual){
                grafico.setColor(Color.YELLOW);
            }
            else{
                grafico.setColor(Color.WHITE);
            }
            grafico.drawString(eleccion[i], 195,120+i*15);
        }
    }
    
}
