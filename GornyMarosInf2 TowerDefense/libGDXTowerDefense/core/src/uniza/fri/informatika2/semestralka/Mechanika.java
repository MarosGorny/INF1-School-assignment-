/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniza.fri.informatika2.semestralka;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import uniza.fri.informatika2.semestralka.nepriatel.Nepriatel;
import veze.Veza;

/**
 *
 * @author maros
 */
public class Mechanika {

    private Texture jednotka;
    private Texture dvojka;
    private Texture trojka;
    private Texture stvorka;
    private Texture patka;

    private Texture jednotkaFull;
    private Texture dvojkaFull;
    private Texture trojkaFull;
    private Texture stvorkaFull;
    private Texture patkaFull;

    private Texture srdce;
    
    private Texture coins;

    private Texture next;

    private Texture cislo1;
    private Texture cislo2;
    private Texture cislo3;
    private Texture cislo4;
    private Texture cislo5;
    private Texture cislo6;
    private Texture cislo7;
    private Texture cislo8;
    private Texture cislo9;
    private Texture cislo0;

    private int level;
    private int peniaze;
    
    /**
     * Konštruktor
     *      Vytvorí všetky obrázky
     *      Nastaví level na -1
     *      Nastaví peniaze na 10
     */
    public Mechanika() {
        this.jednotka = new Texture("oneopa.png");
        this.dvojka = new Texture("twoopa.png");
        this.trojka = new Texture("threeopa.png");
        this.stvorka = new Texture("fouropa.png");
        this.patka = new Texture("fiveopa.png");

        this.jednotkaFull = new Texture("onefull.png");
        this.dvojkaFull = new Texture("twofull.png");
        this.trojkaFull = new Texture("threefull.png");
        this.stvorkaFull = new Texture("fourfull.png");
        this.patkaFull = new Texture("fivefull.png");

        this.srdce = new Texture("heart.png");
        
        this.coins = new Texture("coins.png");

        this.next = new Texture("next.png");

        this.cislo0 = new Texture("0.png");
        this.cislo1 = new Texture("1.png");
        this.cislo2 = new Texture("2.png");
        this.cislo3 = new Texture("3.png");
        this.cislo4 = new Texture("4.png");
        this.cislo5 = new Texture("5.png");
        this.cislo6 = new Texture("6.png");
        this.cislo7 = new Texture("7.png");
        this.cislo8 = new Texture("8.png");
        this.cislo9 = new Texture("9.png");

        this.level = -1;
        this.peniaze = 10;
    }
    
    /**
     * Vráti hodnotu peňazí
     */
    public int getPeniaze() {
        return this.peniaze;
    }
    
    /**
     * Vykreslí všetky vežičky ktoré sa dajú vyberať
     */
    public void vykresliVsetkyVezicky(SpriteBatch batch) {
        batch.draw(this.jednotka, 360, 320);
        batch.draw(this.dvojka, 360, 280);
        batch.draw(this.trojka, 360, 240);
        batch.draw(this.stvorka, 360, 200);
        batch.draw(this.patka, 360, 160);
    }
    
    /**
     * Vykreslí srdiečka, podľa počtu životov
     */
    public void vykresliZivoty(SpriteBatch batch, int zivoty) {
        switch (zivoty) {
            case 1:
                batch.draw(this.srdce, 0, 360);
                break;
            case 2:
                batch.draw(this.srdce, 0, 360);
                batch.draw(this.srdce, 40, 360);
                break;
            case 3:
                batch.draw(this.srdce, 0, 360);
                batch.draw(this.srdce, 40, 360);
                batch.draw(this.srdce, 80, 360);
                break;
            default:               
                break;
        }
    }
    /**
     * Vykreslí čísla
     */
    public void vykresliCisla(SpriteBatch batch) {
        this.vykresliCislaJednotkove(batch);
        this.vykresliCislaDesiatkove(batch);
        this.vykresliCislaStovkove(batch);
        this.vykresliCislaTisickove(batch);
    }
    /**
     * Vykreslí jednotkové číslo
     */
    public void vykresliCislaJednotkove(SpriteBatch batch) {
        int mod10 = this.peniaze % 10;

        switch (mod10) {
            case 1:
                batch.draw(this.cislo1, 344, 372);
                break;
            case 2:
                batch.draw(this.cislo2, 344, 372);
                break;
            case 3:
                batch.draw(this.cislo3, 344, 372);
                break;
            case 4:
                batch.draw(this.cislo4, 344, 372);
                break;
            case 5:
                batch.draw(this.cislo5, 344, 372);
                break;
            case 6:
                batch.draw(this.cislo6, 344, 372);
                break;
            case 7:
                batch.draw(this.cislo7, 344, 372);
                break;
            case 8:
                batch.draw(this.cislo8, 344, 372);
                break;
            case 9:
                batch.draw(this.cislo9, 344, 372);
                break;
            case 0:
                batch.draw(this.cislo0, 344, 372);
                break;

            default:
                batch.draw(this.cislo0, 344, 372);
                break;
        }
    }
    
    /**
     * Vykreslí desiatkové číslo
     */
    public void vykresliCislaDesiatkove(SpriteBatch batch) {

        int mod100 = (this.peniaze % 100) / 10;

        switch (mod100) {
            case 1:
                batch.draw(this.cislo1, 326, 372);
                break;
            case 2:
                batch.draw(this.cislo2, 326, 372);
                break;
            case 3:
                batch.draw(this.cislo3, 326, 372);
                break;
            case 4:
                batch.draw(this.cislo4, 326, 372);
                break;
            case 5:
                batch.draw(this.cislo5, 326, 372);
                break;
            case 6:
                batch.draw(this.cislo6, 326, 372);
                break;
            case 7:
                batch.draw(this.cislo7, 326, 372);
                break;
            case 8:
                batch.draw(this.cislo8, 326, 372);
                break;
            case 9:
                batch.draw(this.cislo9, 326, 372);
                break;
            case 0:
                batch.draw(this.cislo0, 326, 372);

                break;
            default:
                batch.draw(this.cislo0, 326, 372);
                break;
        }
    }
    
    /**
     * Vykreslí stovkové číslo
     */
    public void vykresliCislaStovkove(SpriteBatch batch) {

        int mod1000 = (this.peniaze % 1000) / 100;

        switch (mod1000) {
            case 1:
                batch.draw(this.cislo1, 308, 372);
                break;
            case 2:
                batch.draw(this.cislo2, 308, 372);
                break;
            case 3:
                batch.draw(this.cislo3, 308, 372);
                break;
            case 4:
                batch.draw(this.cislo4, 308, 372);
                break;
            case 5:
                batch.draw(this.cislo5, 308, 372);
                break;
            case 6:
                batch.draw(this.cislo6, 308, 372);
                break;
            case 7:
                batch.draw(this.cislo7, 308, 372);
                break;
            case 8:
                batch.draw(this.cislo8, 308, 372);
                break;
            case 9:
                batch.draw(this.cislo9, 308, 372);
                break;
            case 0:
                batch.draw(this.cislo0, 308, 372);

                break;

            default:
                batch.draw(this.cislo0, 308, 372);
                break;
        }

    }
    
    /**
     * Vykreslí tisíckové číslo
     */
    public void vykresliCislaTisickove(SpriteBatch batch) {

        int mod10000 = (this.peniaze % 10000) / 1000;

        switch (mod10000) {
            case 1:
                batch.draw(this.cislo1, 290, 372);
                break;
            case 2:
                batch.draw(this.cislo2, 290, 372);
                break;
            case 3:
                batch.draw(this.cislo3, 290, 372);
                break;
            case 4:
                batch.draw(this.cislo4, 290, 372);
                break;
            case 5:
                batch.draw(this.cislo5, 290, 372);
                break;
            case 6:
                batch.draw(this.cislo6, 290, 372);
                break;
            case 7:
                batch.draw(this.cislo7, 290, 372);
                break;
            case 8:
                batch.draw(this.cislo8, 290, 372);
                break;
            case 9:
                batch.draw(this.cislo9, 290, 372);
                break;
            case 0:
                batch.draw(this.cislo0, 290, 372);

                break;

            default:
                batch.draw(this.cislo0, 290, 372);
                break;
        }

    }
    
    /**
     *  Vykreslí obrázok mincí 
     */
    public void vykresliCoins(SpriteBatch batch) {
        batch.draw(this.coins, 364, 368 );
    }
    
    /**
     * Vykreslí obrázok na štartovanie ďalšieho levelu
     */
    public void vykresliNext(SpriteBatch batch) {
        batch.draw(this.next, 360, 0);
    }
    
    /**
     * Vykreslí vežičky ktoré sú na výber
     *      Ak sa dajú kúpiť nie sú priehľadné
     *      Ak sa nedajú kúpiť sú 60% nepriehľadné
     */
    public void vykresliSeletcedVezicky(SpriteBatch batch) {
        if (this.peniaze <= 4) {

            batch.draw(this.jednotka, 360, 320);
            batch.draw(this.dvojka, 360, 280);
            batch.draw(this.trojka, 360, 240);
            batch.draw(this.stvorka, 360, 200);
            batch.draw(this.patka, 360, 160);
        }

        if (this.peniaze >= 5 && this.peniaze <= 9) {

            batch.draw(this.jednotkaFull, 360, 320);
            batch.draw(this.dvojka, 360, 280);
            batch.draw(this.trojka, 360, 240);
            batch.draw(this.stvorka, 360, 200);
            batch.draw(this.patka, 360, 160);
        }

        if (this.peniaze >= 10 && this.peniaze <= 14) {

            batch.draw(this.jednotkaFull, 360, 320);
            batch.draw(this.dvojkaFull, 360, 280);
            batch.draw(this.trojkaFull, 360, 240);
            batch.draw(this.stvorka, 360, 200);
            batch.draw(this.patka, 360, 160);
        }

        if (this.peniaze >= 15 && this.peniaze <= 19) {

            batch.draw(this.jednotkaFull, 360, 320);
            batch.draw(this.dvojkaFull, 360, 280);
            batch.draw(this.trojkaFull, 360, 240);
            batch.draw(this.stvorkaFull, 360, 200);
            batch.draw(this.patka, 360, 160);
        }

        if (this.peniaze >= 20) {

            batch.draw(this.jednotkaFull, 360, 320);
            batch.draw(this.dvojkaFull, 360, 280);
            batch.draw(this.trojkaFull, 360, 240);
            batch.draw(this.stvorkaFull, 360, 200);
            batch.draw(this.patkaFull, 360, 160);
        }
    }
    
    /**
     * Pridá do peňazí hodnotu daného nepriateľa
     */
    public void pridajPeniaze(Nepriatel nepriatel) {
        this.peniaze += nepriatel.getHodnota();
    }
    
    /**
     * Odobere z peňazí hodnotu danej veže
     */
    public void odoberPeniaze(Veza veza) {
        this.peniaze -= veza.getHodnota();
    }
    
    /**
     * Vráti level mechaniky
     */
    public int getLevel() {
        return this.level;
    }
    
    /**
     * Inkrementuje level
     */
    public void pridajLevel() {
        this.level++;
    }
}
