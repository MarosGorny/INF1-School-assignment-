/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veze;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import strela.Strela;
import strela.StrelyNaMape;
import uniza.fri.informatika2.semestralka.nepriatel.Nepriatel;
import uniza.fri.informatika2.semestralka.nepriatel.TovarnaNaNepriatelov;
import static veze.Veza.VELKOST;

/**
 *
 * @author maros
 */
public class VezickyNaMape {

    private ArrayList<Veza> vezicky;
    private int peniaze;
    
    private ArrayList<Strela> pomocnyArStriel;
    private ArrayList<Nepriatel> pomocnyArNepriatelov;
    private TovarnaNaNepriatelov tovarna;

    private StrelyNaMape strelyNaMape;
    
    /**
     * Konštruktor
     *      vytvorí ArrayList vežičiek, pomocných striel
     *              Továrnu
     *              Strely na mape
     *      nastaví peniaze na 0              
     */
    public VezickyNaMape() {
        this.vezicky = new ArrayList<Veza>();        
        this.pomocnyArStriel = new ArrayList<Strela>();
        this.tovarna = new TovarnaNaNepriatelov();
        this.strelyNaMape = new StrelyNaMape();
        this.peniaze = 0;
    }
    
    /**
     * Do ArrayListu pridá danú vežu
     */
    public void pridajVezicku(Veza veza) {
        this.vezicky.add(veza);
    }   
    
    /**
     * Skopíruje ArrayList do pomocného ArrayListu
     */    
    public void skopirujArNepriatelov(ArrayList array) {
        this.pomocnyArNepriatelov = array;       
    }

    /**
     * Skopíruje ArrayList striel do pomocného ArrayListu
     */ 
    public void skopirujArStriel() {
        this.pomocnyArStriel = this.strelyNaMape.dajAktArrayStriel();        
    }
    
    /**
     * Každá strela sa pohne smerom ku nepriateľovi
     */
    public void strelyHybteSa() {
        for (Strela strela : this.pomocnyArStriel) {
            strela.strielajNaNepriatela();
        }
    }
    
    /**
     * Vymaže mŕtve strely na mape
     */
    public void vymazMrtveStrely() {
        this.strelyNaMape.vymazMrtveStrely();
    }
    
    /**
     * Každá strela, ktorá má kolíziu s nepriateľom sa vymaže
     *      ak nastane kolízia, pridajú sa peniaze
     */
    public void kolizieStriel(SpriteBatch batch) {
        for (Strela strela : this.pomocnyArStriel) {
            if (strela.koliziaSNepriatelom(batch)) {
                this.peniaze += strela.getNepriatel().getHodnota();
                this.strelyNaMape.odoberStrelu(strela);
            }
        }
    }
    
    /**
     * vykreslí každú strelu
     */
    public void vykresliVsetkyStrely(SpriteBatch batch) {
        for (Strela strela : this.pomocnyArStriel) {
            strela.vykresli(batch);
        }
    }
    
    /**
     * Ak sa bude vežička nachádzať na vhodnom mieste, vráti pravdu
     */
    public boolean mozemPridatVezicku(float x, float y) {
        if (this.convertedY(y) >= 9 * VELKOST) {
            return false;
        } else if (x >= 9 * VELKOST) {
            return false;
        } else if (this.convertedY(y) <= 8 * VELKOST && this.convertedY(y) >= 7 * VELKOST && x <= 8 * VELKOST) {
            return false;
        } else if (this.convertedY(y) <= 7 * VELKOST && this.convertedY(y) >= 6 * VELKOST && x >= 7 * VELKOST && x <= 8 * VELKOST) {
            return false;
        } else if (this.convertedY(y) <= 6 * VELKOST && this.convertedY(y) >= 5 * VELKOST && x >= 1 * VELKOST && x <= 8 * VELKOST) {
            return false;
        } else if (this.convertedY(y) <= 5 * VELKOST && this.convertedY(y) >= 4 * VELKOST && x >= 1 * VELKOST && x <= 2 * VELKOST) {
            return false;
        } else if (this.convertedY(y) <= 4 * VELKOST && this.convertedY(y) >= 3 * VELKOST && x >= 1 * VELKOST && x <= 2 * VELKOST) {
            return false;
        } else if (this.convertedY(y) <= 4 * VELKOST && this.convertedY(y) >= 3 * VELKOST && x >= 3 * VELKOST && x <= 6 * VELKOST) {
            return false;
        } else if (this.convertedY(y) <= 3 * VELKOST && this.convertedY(y) >= 2 * VELKOST && x >= 1 * VELKOST && x <= 2 * VELKOST) {
            return false;
        } else if (this.convertedY(y) <= 3 * VELKOST && this.convertedY(y) >= 2 * VELKOST && x >= 3 * VELKOST && x <= 4 * VELKOST) {
            return false;
        } else if (this.convertedY(y) <= 3 * VELKOST && this.convertedY(y) >= 2 * VELKOST && x >= 5 * VELKOST && x <= 6 * VELKOST) {
            return false;
        } else if (this.convertedY(y) <= 2 * VELKOST && this.convertedY(y) >= 1 * VELKOST && x >= 1 * VELKOST && x <= 4 * VELKOST) {
            return false;
        } else if (this.convertedY(y) <= 2 * VELKOST && this.convertedY(y) >= 1 * VELKOST && x >= 5 * VELKOST) {
            return false;
        }
        return true;

    }
    
    /**
     * Ak už na danej pozícii nachádza vežička, vráti pravdu
     */
    public boolean uzExistujeVezicka(float x, float y) {
        float novaVezX;
        float novaVezY;
        float convertedYLok;
        novaVezX = x - x % VELKOST;
        convertedYLok = this.convertedY(y);
        novaVezY = convertedYLok - convertedYLok % VELKOST;

        for (Veza veza : this.vezicky) {
            if (veza.getX() == novaVezX && veza.getY() == novaVezY) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Vykreslí každú strelu z ArrayListu
     */
    public void vykresliKazduStrelu(SpriteBatch batch) {
        for (Strela strela : this.pomocnyArStriel) {
            strela.vykresli(batch);
        }        
    }
    
    /**
     * Konvertuje Y súradnicu
     */
    public float convertedY(float suradnica) {
        float vysledok = Gdx.graphics.getHeight() - 1 - suradnica;
        return vysledok;
    }
    
    /**
     * Vykreslí každú vežičku z ArrayListu
     */
    public void vykresliVezicky(SpriteBatch batch) {
        for (Veza veza : this.vezicky) {
            veza.vykresli(batch);
        }
    }   
    /**
     * Každá veža skontroluje každého nepriateľa
     *      ak má veža nepriateľa v dosahu,
     *      vytvorí strelu, pridá ju do ArrayListu,
     * Každá veža strieľa na nepriateľa v dosahu
     */
    public void vezickyStrielajte() {
        for (Veza veza : this.vezicky) {
            for (Nepriatel nepriatel : this.pomocnyArNepriatelov) {
                if (veza.jeNepriatelVDosahu(nepriatel)) {
                    Strela pomocnaStrela = veza.vytvorStrelu(nepriatel);
                    
                    this.strelyNaMape.pridajStrelu(pomocnaStrela);
                    this.strelyNaMape.vsetkyVezickyStrielajteNaNepriatela();                    
                    break;                    
                }
            }
        }
    }
}
