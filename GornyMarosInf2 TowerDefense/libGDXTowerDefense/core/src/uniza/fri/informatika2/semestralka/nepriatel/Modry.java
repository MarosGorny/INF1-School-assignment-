/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniza.fri.informatika2.semestralka.nepriatel;

import com.badlogic.gdx.graphics.Texture;

/**
 *
 * @author maros
 */
public class Modry extends Nepriatel {
    
    /**
     * Konštruktor, vytvorí nového nepriateľa            
     *         2 životy
     *         1 rýchlosť
     *         1 hodnota
     */
    public Modry() {
        super(new Texture("modry.png"), 2, 1, 1);
    }
    
}
