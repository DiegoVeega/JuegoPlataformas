/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapeo;

import Juego.PanelJuego;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;

/**
 *
 * @author diego
 */
public class Mapeo {
    private double x;
    private double y;
    
    private int xx; //min
    private int yy; //min
    private int X; //max
    private int Y;//max
    
    private double entre;//tween
    
    private int[][] mapa;//map
    private int ordentam;//tilesize
    private int numfila;//numrows
    private int numcolum;//numcolumn
    private int ancho;
    private int alto;
    
    private BufferedImage asignarorden; //tileset
    private int numorden; //numtileA
    private Orden[][] orden; //tiles
    
    private int nofila; //rowoff
    private int nocolum;//columnoff
    private int filasdibujo; //rowdraw
    private int columndibujo;//colsdraw
    
    public Mapeo(int ordentam){
        this.ordentam=ordentam;
        filasdibujo=PanelJuego.ALTO/ordentam+2;
        columndibujo=PanelJuego.ANCHO/ordentam+2;
        entre=0.7;
    }

    public void cargar(String c){
        try{
            asignarorden=ImageIO.read(getClass().getResource(c));
            numorden=asignarorden.getWidth() / ordentam;
            orden=new Orden[2][numorden];
            BufferedImage imagenn;
            for (int col = 0; col < numorden; col++) {
                imagenn=asignarorden.getSubimage(col*ordentam, 0, ordentam, ordentam);
                orden[0][col]=new Orden(imagenn, Orden.NORMAL);
                imagenn=asignarorden.getSubimage(col*ordentam, ordentam, ordentam, ordentam);
                orden[1][col]=new Orden(imagenn, Orden.BLOQUEADO);
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void cargarMapa(String c){
        try{
            InputStream de=getClass().getResourceAsStream(c);
            BufferedReader lee=new BufferedReader(
            new InputStreamReader(de));
            numcolum=Integer.parseInt(lee.readLine());
            numfila=Integer.parseInt(lee.readLine());
            mapa = new int[numfila][numcolum];
            ancho=numcolum*ordentam;
            alto=numfila*ordentam;
            
            String limite="//s+";
            for (int fila = 0; fila < numfila; fila++) {
                String linea=lee.readLine();
                String[] var=linea.split(limite);
                for (int col = 0; col < numcolum; col++) {
                    mapa[fila][col]=Integer.parseInt(var[col]);
                    
                }
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public int getOrdentam() {
        return ordentam;
    }
    
    public int getx(){
        return (int)x;
    }
    
    public int gety(){
        return (int)y;
    }
    
    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }
    
    public int getTipo(int fila, int col){
        int filcol=mapa[fila][col];
        int f=filcol/numorden;
        int c=filcol%numorden;
        return orden[fila][col].getTipo();
    }
    
    public void setPosition(double x, double y){
        this.x+=(x-this.x) * entre;
        this.y+=(y-this.y) * entre;
        
        if(x<xx) x=xx;
        if(y<yy) y=yy;
        if(x>X) x=X;
        if(y>Y) y=Y;
    }
    public void dibujar(Graphics2D grafico){
        for(int fila=nofila; fila< nofila+filasdibujo; fila++){
            
            if(fila>=numfila) break;
            
            for(int col = nocolum; col<nocolum+columndibujo; col++){
            
            if(col>=numcolum) break;
            if(mapa[fila][col]==0) continue;
            int filcol=mapa[fila][col];
            int f=filcol/numorden;
            int c=filcol%numorden;
            
            grafico.drawImage(orden[f][c].getImage(), (int)x+col*ordentam,(int)y+fila*ordentam, null);
            }
        }
    }
}
