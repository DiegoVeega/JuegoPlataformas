/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estado;

import Juego.PanelJuego;
import Mapeo.Mapeo;
import java.awt.Color;
import java.awt.Graphics2D;
import javafx.scene.Node;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javax.swing.JLabel;

/**
 *
 * @author diego
 */
public class Nivel1 extends Estado{
    
    private Mapeo mapeo;
    
    public Nivel1(ControladorEstados cde) {
        this.cde=cde;
        iniciar();
    }

    @Override
    public void iniciar() {
        
        mapeo=new Mapeo(30);
        mapeo.cargar("/RECURSOS/plataforma.png");
        mapeo.cargarMapa("/RECURSOS/nivel.tmx"); //FALTANTE INVESTIGAR
        mapeo.setPosition(0, 0);
    }

    @Override
    public void actualizar() {
        
    }

    @Override
    public void dibujar(Graphics2D grafico) {
        grafico.setColor(Color.DARK_GRAY);
        grafico.fillRect(0, 0, PanelJuego.ANCHO, PanelJuego.ALTO);
        mapeo.dibujar(grafico);
    }

    @Override
    public void presion(int t) {
        
    }

    @Override
    public void seleccion(int t) {
        
    }
}
