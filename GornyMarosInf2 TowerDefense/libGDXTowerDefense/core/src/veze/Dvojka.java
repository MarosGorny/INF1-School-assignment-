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
public class Dvojka extends Veza {
    
    /**
     * Vytvorí novú vežu na danej pozícii
     *      2 dosah
     *      1 sila
     *      2 rýchlosť
     *      10 hodnota
     */
    public Dvojka(float x, float y) {
        super(new Texture("two.png"), new Texture("dosah260.png"), x, y, 2, 1, 2, 10);
    } 
    
    /**
     * Vytvorí novú vežu na danej pozícii
     *      vráti Dvojkovú vežičku, na danej pozícii
     */
    @Override
    public Veza vytvorVezicku() {
        return (new Dvojka(Gdx.input.getX(), Gdx.input.getY()));
    }
    
}
