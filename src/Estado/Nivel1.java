/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estado;

import java.awt.Graphics2D;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javax.swing.JLabel;

/**
 *
 * @author diego
 */
public class Nivel1 extends Estado{
    
    public Nivel1(ControladorEstados cde) {
        this.cde=cde;
        construccion();
    }
    
    public static final String[] Nivel1=new String[]{
        "000000000000000000000000000000000000000000000000000",
        "000000000000000000000000000000000000000000000000000",
        "0000000000000000000000000000S0000000000000000000000",
        "0000000000000000000000000000S0000000000000000000000",
        "0000000000000000000SS0000000SSS00000000000000000000",
        "0000000000000000SS0000S0000SS0000000000000000000000",
        "000000S000000SS0000000000000SSSS0000SSS0SS000000000",
        "0000S0S0000S0S0000000S000000000000S0000000000000000",
        "SSSSSSSSSSSS0SSSSSSSSS0SS0SSSSSSSSS00000000SSSSSSSS"
    };
    
    public void construccion(){
        for (int i = 0; i < Nivel1.length; i++) {
            String linea = Nivel1[i];
            for (int j = 0; j < linea.length(); j++) {
                switch(linea.charAt(j)){
                    case '0':
                        break;
                    case '1':
                        
                }
                
            }
            
        }
    }

    @Override
    public void iniciar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dibujar(Graphics2D grafico) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void presion(int t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void seleccion(int t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
