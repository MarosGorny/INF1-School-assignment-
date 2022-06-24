/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veze;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import strela.Strela;
import uniza.fri.informatika2.semestralka.nepriatel.Nepriatel;

/**
 *
 * @author maros
 */
public abstract class Veza {

    public static final int VELKOST = 40;
    private Texture texture;
    private Texture dosahTexture;

    private float x;
    private float y;
    private int dosah;
    private int sila;
    private int hodnota;
    private int rychlost;
    
    /**
     * Konštruktor
     *      priradí textúru vežičky, textúru dosahu, pozíciu X a Y, dosah, 
     *      silu, hodnotu a rýchlosť
     */
    public Veza(Texture texture, Texture dosahTexture, float x, float y, int dosah, int sila, int rychlost, int hodnota) {
        this.texture = texture;
        this.dosahTexture = dosahTexture;
        this.x = x - x % VELKOST;
        float konvertovanyY = this.convertedY(y);
        this.y = konvertovanyY - konvertovanyY % VELKOST;
        this.dosah = dosah;
        this.sila = sila;
        this.hodnota = hodnota;
        this.rychlost = rychlost;
    }
    /**
     *  vráti novú vežu
     */
    public abstract Veza vytvorVezicku();
    
    /**
     *  Vráti novú strelu
     */
    public Strela vytvorStrelu(Nepriatel nepriatel) {
        return new Strela(this.x, this.y, 1, nepriatel, this);
    }
    /**
     * Ak sa nepriateľ nachádza v danom dosahu, vráti pravdu
     */
    public boolean jeNepriatelVDosahu(Nepriatel nepriatel) {
        float nepXMid = nepriatel.getX() + 20;
        float nepYMid = nepriatel.getY() + 20;
        float mojXMid = this.x + 20;
        float mojYMid = this.y + 20;
        if (nepXMid <= mojXMid + 20 + (this.dosah * VELKOST)) {
            if (nepXMid >= mojXMid - 20 - (this.dosah * VELKOST)) {
                if (nepYMid <= mojYMid + 20 + (this.dosah * VELKOST)) {
                    if (nepYMid >= mojYMid - 20 - (this.dosah * VELKOST)) {
                        return true;
                    }
                }
            }
        }        
        return false;
    }
    
    /**
     * Vykreslí vežičku v strede štvorca
     */
    public void vykresli(SpriteBatch batch) {
        batch.draw(this.texture, this.x, this.y);
        float pomocnyX = this.x - this.dosahTexture.getWidth() / 2;
        float pomocnyY = this.y - this.dosahTexture.getHeight() / 2;
        batch.draw(this.dosahTexture, pomocnyX + VELKOST / 2, pomocnyY + VELKOST / 2);
    }

    /**
     * vráti upravenú súradnicu obrázku na stred
     */
    public float naStredX(float suradnica) {
        float modulo = suradnica % VELKOST;
        float vysledok = suradnica - modulo - this.texture.getWidth() / 2;
        return vysledok;
    }
    
    /**
     * vráti upravenú súradnicu obrázku na stred
     */
    public float naStredY(float suradnica) {
        float modulo = suradnica % VELKOST;
        float vysledok = suradnica - modulo - this.texture.getHeight() / 2;
        return vysledok;
    }

    /**
     * vráti upravenú Y súradnicu myšky
     */
    public float convertedY(float suradnica) {
        float vysledok = Gdx.graphics.getHeight() - 1 - suradnica;
        return vysledok;
    }
    
    /**
     * vráti X súradnicu
     */
    public float getX() {
        return this.x;
    }
    
    /**
     * nastaví X súradnicu
     */
    public void setX(float x) {
        this.x = x;
    }
    
    /**
     * vráti Y súradnicu
     */
    public float getY() {
        return this.y;
    }
    
    /**
     * nastaví Y súradnicu
     */
    public void setY(float y) {
        this.y = y;
    }
    
    /**
     * vráti dosah veže
     */
    public int getDosah() {
        return this.dosah;
    }
    
    /**
     * vráti silu veže
     */
    public int getSila() {
        return this.sila;
    }
    
    /**
     * vráti hodnotu veže
     */
    public int getHodnota() {
        return this.hodnota;
    }
    
    /**
     * vráti rýchlosť
     */
    public int getRychlost() {
        return this.rychlost;
    }
}
