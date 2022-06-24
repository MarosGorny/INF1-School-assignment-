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
public class Zeleny extends Nepriatel {
    
    /**
     * Konštruktor, vytvorí nového nepriateľa            
     *         1 život
     *         4 rýchlosť
     *         3 hodnota
     */
    public Zeleny() {
        super(new Texture("zeleny.png"), 1, 4, 3);
    }
    
}
