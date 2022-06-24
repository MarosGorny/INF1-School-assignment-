/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniza.fri.informatika2.semestralka.nepriatel;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author maros
 */
public class TovarnaNaNepriatelov {

    private ArrayList<Nepriatel> nepriatelia;
    private int pocitadloCasu;
    private boolean dalsiaVlna;
    
    private Nepriatel mrtvyNepriatel;
    
    /**
     * Konštruktor
     *      vytvorí nový ArrayList nepriateľov
     *      nastaví počítadlo času na 0, ďalšiu vlnu na pravdu
     *      Do mŕtveho nepriateľa nepridá nič
     */
    public TovarnaNaNepriatelov() {
        this.nepriatelia = new ArrayList<Nepriatel>();
        this.pocitadloCasu = 0;
        this.dalsiaVlna = true;
        this.mrtvyNepriatel = null;
    }
    
    /**
     * Vráti kópiu ArrayListu nepriateľov
     */
    public ArrayList<Nepriatel> dajAktNep() {
        return (ArrayList<Nepriatel>)this.nepriatelia.clone();
    }
    
    /**
     * Vytvorí nepriateľa vždy keď : počítadlo času modulo 40 sa rovná 0
     *      počítadlo času sa inkrementuje
     */
    public void vytvorVlnuNepriatelov(Nepriatel nepriatel) {
        if (this.pocitadloCasu < 401) {
            this.pocitadloCasu++;
        }

        if (this.pocitadloCasu % 40 == 0 && this.pocitadloCasu < 401) {
            this.nepriatelia.add(nepriatel);
        }
    }
    
    /**
     * vráti pravdivostnú hodnotu ďalšej vlne
     */
    public boolean isDalsiaVlna() {
        return this.dalsiaVlna;
    }
    
    /**
     * Resetne počítadlo času
     */
    public void resetPocitadloCasu() {
        this.pocitadloCasu = 0;
    }
    
    /**
     * Vráti nepriateľa daného indexu
     */
    public Nepriatel getNepriatel(int index) {
        return this.nepriatelia.get(index);
    }

    /**
     * Vykreslí každého nepriateľa
     */
    public void vykresliVsetkychNepriatelov(SpriteBatch batch) {
        for (Nepriatel nepriatel : this.nepriatelia) {
            nepriatel.vykresli(batch);
        }
    }
    
    /**
     * Každý nepriateľ sa posunie o svoju rýchlosť
     */
    public void cestujteVsetciVTovarni() {
        for (Nepriatel nepriatel : this.nepriatelia) {
            nepriatel.cestuj(nepriatel.getRychlost());
        }
    }
    
    /**
     * vymaže "mŕtveho" nepriateľa
     *      ak je nepriateľ mŕtvy, tak ho vymaže z ArrayListu
     */
    public void vymazMrtvychNepriatelov() {
        this.mrtvyNepriatel = null;
        for (Iterator<Nepriatel> iterator = this.nepriatelia.iterator(); iterator.hasNext();) {
            Nepriatel pomocnyNepriatel = iterator.next();
            if (pomocnyNepriatel.somMrtvy()) {
                this.mrtvyNepriatel = pomocnyNepriatel;
                iterator.remove();                
            }
        }
    }
    
    /**
     * Vráti mŕtveho nepriateľa
     */
    public Nepriatel getMrtvyNepriatel() {
        return this.mrtvyNepriatel;
    }
    
    /**
     * Ak nepriateľ prešiel cez cieľ, vráti pravdu
     *      a odstráni ho z ArrayListu
     */
    public boolean presielCezCiel() {
        for (Nepriatel nepriatel : this.nepriatelia) {
            if (nepriatel.getX() >= 360) {
                this.nepriatelia.remove(nepriatel);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Vráti veľkosť ArrayListu nepriateľov
     */
    public int sizeNepriatelov() {
        return this.nepriatelia.size();
    }
}
