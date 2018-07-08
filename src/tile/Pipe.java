/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tile;

import Juegos.Handler;
import Juegos.Id;
import entity.mob.Plant;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Julio
 */
public class Pipe extends Tile{

    public Pipe(int x, int y, int width, int height, boolean solid, Id id, Handler handler, int facing, boolean plant) {
        super(x, y, width, height, solid, id, handler);
        this.facing = facing;
        if(plant) handler.addEntity(new Plant(getX(),getY()-62,getWidth(),64,Id.planta,handler));
    }

    @Override
    public void render(Graphics g) {
            g.setColor(new Color(0,128,0));
            g.fillRect(x, y, width, height);
    }

    @Override
    public void tick() {}
    
}
