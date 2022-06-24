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
public class Trojka extends Veza {
    
    /**
     * Vytvorí novú vežu na danej pozícii
     *      1 dosah
     *      2 sila
     *      2 rýchlosť
     *      10 hodnota
     */
    public Trojka(float x, float y) {
        super(new Texture("three.png"), new Texture("dosah60.png"), x, y, 1, 2, 2, 10);
    }
    
    /**
     * Vytvorí novú vežu na danej pozícii
     *      vráti Trojkovú vežičku, na danej pozícii
     */
    @Override
    public Veza vytvorVezicku() {
        return (new Trojka(Gdx.input.getX(), Gdx.input.getY()));
    }
    
}
