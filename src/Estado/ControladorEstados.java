/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estado;

import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class ControladorEstados {
    
    private ArrayList<Estado> estado;
    private int EstadoActual;
    
    public static final int MENU=0;
    public static final int NIVEL1=1;

    public ControladorEstados() {
        estado=new ArrayList<Estado>();
        EstadoActual=MENU;
        estado.add(new Menu(this));
        estado.add(new Nivel1(this)); //agregada la entrada al nivel 1
        
    }
    public void setState(int estad){
        EstadoActual=estad;
        estado.get(EstadoActual).iniciar();
    }
    public void actualizar(){
        estado.get(EstadoActual).actualizar();
    }
    public void dibujar(java.awt.Graphics2D g){
        estado.get(EstadoActual).dibujar(g);
    }
    //TECLAS
    public void presion(int t){
        estado.get(EstadoActual).presion(t);
    }
    public void seleccion(int t){
        estado.get(EstadoActual).seleccion(t);
    }
}
