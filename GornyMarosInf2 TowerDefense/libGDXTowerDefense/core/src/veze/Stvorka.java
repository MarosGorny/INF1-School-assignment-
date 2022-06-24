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
public class Stvorka extends Veza {
    
    /**
     * Vytvorí novú vežu na danej pozícii
     *      1 dosah
     *      1 sila
     *      5 rýchlosť
     *      15 hodnota
     */
    public Stvorka(float x, float y) {
        super(new Texture("four.png"), new Texture("dosah60.png"), x, y, 1, 1, 5, 15);
    }
    
    /**
     * Vytvorí novú vežu na danej pozícii
     *      vráti Štvorkovú vežičku, na danej pozícii
     */
    @Override
    public Veza vytvorVezicku() {
        return (new Stvorka(Gdx.input.getX(), Gdx.input.getY()));
    }

}
