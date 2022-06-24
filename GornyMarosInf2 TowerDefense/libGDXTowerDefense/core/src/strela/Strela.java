/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strela;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import uniza.fri.informatika2.semestralka.nepriatel.Nepriatel;
import veze.Veza;

/**
 *
 * @author maros
 */
public class Strela {

    private Texture texture;
    
    private float x;
    private float y;
    
    private int rychlost;
    
    private Nepriatel nepriatel;
    
    private boolean zije;
    
    private Veza veza;
    
    /**
     * Konštruktor pre strelu
     * Nastaví sa textúra
     *      pozícia X,Y
     *      rýchlosť strely
     *      nepriateľ strely
     *      veža z ktorej strela ide
     *      boolean žije, nastaví na pravdu
     */
    public Strela(float x, float y, int rychlost, Nepriatel nepriatel, Veza veza) {
        this.texture = new Texture("strela.png");
        this.x = x + 18;
        this.y = y + 18;
        this.rychlost = rychlost;
        this.nepriatel = nepriatel;
        this.zije = true;
        this.veza = veza;
    }
    
    /**
     * Strela sa začne pohybovať smerom ku nepriateľovi
     */
    public void strielajNaNepriatela() {
        if (this.nepriatel.getX() + 18 > this.x ) {
            this.x += this.veza.getRychlost();
        }

        if (this.nepriatel.getY() + 18 > this.y ) {
            this.y += this.veza.getRychlost();
        }

        if (this.nepriatel.getX() + 18 < this.x ) {
            this.x -= this.veza.getRychlost();
        }

        if (this.nepriatel.getY() + 18 < this.y ) {
            this.y -= this.veza.getRychlost();
        }        
    }
    /**
     * Vráti nepriateľa danej strely
     */
    public Nepriatel getNepriatel() {
        return this.nepriatel;
    }
    
    /**
     * Ak má strela kolíziu s nepriateľom
     *      nastaví boolean zije na nepravdu
     * Vráti pravdu
     */
    public boolean koliziaSNepriatelom(SpriteBatch batch) {
        if (this.nepriatel.getX() == this.x - 18 && this.nepriatel.getY() == this.y - 18) {           
            this.nepriatel.odoberZivot(this.veza);
            this.zije = false;
            
            return true;
        }
        return false;
    }
    
    /**
     * Vráti pravdivostnú hodnotu booleanu "Zije"
     */
    public boolean isZije() {        
        return this.zije;
    }
    
    /**
     *  ak je nepriateľ strely mŕtvy, vráti pravdu
     */
    public boolean mrtvyNepriatel() {
        if (this.nepriatel.somMrtvy()) {
            return true;
        }
        return false;
    }
    
    /**
     * ak strela žije, vykreslí sa
     */
    public void vykresli(SpriteBatch batch) {
        if (this.zije) {
            batch.draw(this.texture, this.x, this.y);
        }        
    }  
}
