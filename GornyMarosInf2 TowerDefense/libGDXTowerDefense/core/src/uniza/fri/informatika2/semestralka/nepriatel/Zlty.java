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
public class Zlty extends Nepriatel {
    
    /**
     * Konštruktor, vytvorí nového nepriateľa            
     *         8 životov
     *         1 rýchlosť
     *         4 hodnota
     */
    public Zlty() {
        super(new Texture("zlty.png"), 8, 1, 4);
    }

}
