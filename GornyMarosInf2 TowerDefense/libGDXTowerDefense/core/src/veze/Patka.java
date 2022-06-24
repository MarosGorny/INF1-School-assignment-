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
public class Patka extends Veza {
    
    /**
     * Vytvorí novú vežu na danej pozícii
     *      2 dosah
     *      2 sila
     *      5 rýchlosť
     *      20 hodnota
     */
    public Patka(float x, float y) {
        super(new Texture("five.png"), new Texture("dosah260.png"), x, y, 2, 2, 5, 20);
    }
    
    /**
     * Vytvorí novú vežu na danej pozícii
     *      vráti Päťkovú vežičku, na danej pozícii
     */
    @Override
    public Veza vytvorVezicku() {
        return (new Patka(Gdx.input.getX(), Gdx.input.getY()));
    }
    
}
