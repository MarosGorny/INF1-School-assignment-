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
public class Cerveny extends Nepriatel {
    
    /**
     * Konštruktor, vytvorí nového nepriateľa            
     *         1 život
     *         1 rýchlosť
     *         1 hodnota
     */
    public Cerveny() {
        super(new Texture("cerveny.png"), 1, 1, 1);
        
    }
    
    
    
}
