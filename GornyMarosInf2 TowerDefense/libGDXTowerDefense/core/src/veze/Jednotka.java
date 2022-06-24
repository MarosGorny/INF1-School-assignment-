/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veze;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 *
 * @author maros
 */
public class Jednotka extends Veza {
    
    /**
     * Vytvorí novú vežu na danej pozícii
     *      1 dosah
     *      1 sila
     *      1 rýchlosť
     *      5 hodnota
     */
    public Jednotka(float x, float y) {
        super(new Texture("one.png"), new Texture("dosah60.png"), x , y, 1, 1, 1, 5);        
    }
    
     /**
     * Vytvorí novú vežu na danej pozícii
     *      vráti Jednotkovú vežičku, na danej pozícii
     */
    @Override
    public Veza vytvorVezicku() {        
        return (new Jednotka(Gdx.input.getX(), Gdx.input.getY()));    
    }    
}
