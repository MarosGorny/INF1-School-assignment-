/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniza.fri.informatika2.semestralka.nepriatel;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import veze.Veza;

/**
 *
 * @author maros
 */
public abstract class Nepriatel {

    public static final int VELKOST = 40;

    private int zivot;
    private int rychlost;
    private int hodnota;

    private Texture texture;
    
    private float x;
    private float y;
    
    /**
     * Konštruktor,           
     *         priradí textúru, život, rýchlosť, hodnotu a pozíciu X,Y*                 
     */
    public Nepriatel(Texture texture, int zivot, int rychlost, int hodnota) {
        this.x = -1 * VELKOST;
        this.y = 7 * this.VELKOST;

        this.texture = texture;
        this.zivot = zivot;
        this.rychlost = rychlost;
        this.hodnota = hodnota;        
    }
    
    /**
     * Nepriateľ sa vykreslí
     */
    public void vykresli(SpriteBatch batch) {
        batch.draw(this.texture, this.x, this.y);
    }
    
    /**
     * Vráti život nepriateľa
     */
    public int getZivot() {        
        return this.zivot;
    }
    
    /**
     * Vráti hodnotu
     */
    public int getHodnota() {
        return this.hodnota;
    }
    
    /**
     * Vráti rýchlosť
     */
    public int getRychlost() {
        return this.rychlost;
    }
    /**
     * Ak má nepriateľ 0 alebo menej životov, vráti pravdu
     */
    public boolean somMrtvy() {
        return (this.zivot <= 0);                
    }
    
    /**
     * Odobere nepriateľovi život o hodnote sily veže
     */
    public void odoberZivot(Veza veza) {
        this.zivot -= veza.getSila();
    }
    
    /**
     * Nepriateľ sa pohne o danú rýchlosť po danej ceste
     */
    public void cestuj(int rychlost) {        
        
        if (this.getY() == 7 * this.VELKOST && this.getX() < 7 * this.VELKOST) {
            this.setX(this.getX() + rychlost);
        } else if ((this.getY() < 8 * this.VELKOST && this.getY() > 5 * this.VELKOST) && this.getX() == 7 * this.VELKOST) {
            this.setY(this.getY() - rychlost);
        } else if (this.getY() == 5 * this.VELKOST && (this.getX() < 8 * this.VELKOST && this.getX() > this.VELKOST)) {
            this.setX(this.getX() - rychlost);
        } else if ((this.getY() < 6 * this.VELKOST && this.getY() > this.VELKOST) && this.getX() == 1 * this.VELKOST) {
            this.setY(this.getY() - rychlost);
        } else if (this.getY() == 1 * VELKOST && (this.getX() >= this.VELKOST && this.getX() < 3 * this.VELKOST)) {
            this.setX(this.getX() + rychlost);
        } else if ((this.getY() < 3 * this.VELKOST && this.getY() >= this.VELKOST) && this.getX() == 3 * this.VELKOST) {
            this.setY(this.getY() + rychlost);
        } else if (this.getY() == 3 * this.VELKOST && (this.getX() >= 3 * this.VELKOST && this.getX() < 5 * this.VELKOST)) {
            this.setX(this.getX() + rychlost);
        } else if ((this.getY() <= 3 * this.VELKOST && this.getY() > this.VELKOST) && this.getX() == 5 * this.VELKOST) {
            this.setY(this.getY() - rychlost);
        } else if (this.getY() == 1 * this.VELKOST && (this.getX() >= 5 * this.VELKOST && this.getX() < 9 * this.VELKOST)) {
            this.setX(this.getX() + rychlost);
        }
    }

    /**
     * vráti X súradnicu
     */
    public float getX() {
        return this.x;
    }

    /**
     * Nastaví pozíciu X
     */
    private void setX(float x) {
        this.x = x;
    }
    /**
     *  vráti Y súradnicu 
     */
    public float getY() {
        return this.y;
    }
    
    /**
     * nastaví Y súradnicu
     */
    private void setY(float y) {
        this.y = y;
    } 
}
