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
public class Tyrkysovy extends Nepriatel {
    
    /**
     * Konštruktor, vytvorí nového nepriateľa            
     *         2 životy
     *         2 rýchlosť
     *         2 hodnota
     */
    public Tyrkysovy() {
        super(new Texture("tyrkysovy.png"), 2, 2, 2);
    }
    
}
