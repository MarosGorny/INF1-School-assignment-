/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strela;


import java.util.ArrayList;
import java.util.Iterator;
import uniza.fri.informatika2.semestralka.nepriatel.Nepriatel;
import veze.Veza;

/**
 *
 * @author maros
 */
public class StrelyNaMape {

    private ArrayList<Strela> zoznamStriel;
    
    /**
     * Konštruktor 
     *  Vytvorí ArrayList striel
     */
    public StrelyNaMape() {
        this.zoznamStriel = new ArrayList<Strela>();
    }
    
    /**
     * Vráti ArrayList striel 
     */
    public ArrayList<Strela> dajAktArrayStriel() {
        return (ArrayList<Strela>)this.zoznamStriel.clone() ;
    }
    
    /**
     * Ak nepriateľ strely už zomrel, tak sa odstráni aj daná strela
     */
    public void vymazMrtveStrely() {
        for (Iterator<Strela> iterator = this.zoznamStriel.iterator(); iterator.hasNext();) {
            Strela pomocnaStrela = iterator.next();
            if (pomocnaStrela.mrtvyNepriatel()) {
                iterator.remove();                
            }
        }
    }
    
    /**
     * Do ArrayListu sa pridá daná strela
     */
    public void pridajStrelu(Strela strela) {
        this.zoznamStriel.add(strela);
    }
    
    /**
     * Z ArrayListu vymaže danú strelu
     */
    public void odoberStrelu(Strela strela) {
        this.zoznamStriel.remove(strela);
    }
    
    /**
     * do ArrayListu pridá novú strelu
     */
    public void vytvorStreluPreVezu(Veza veza, Nepriatel nepriatel) {
        this.zoznamStriel.add(new Strela(veza.getX(), veza.getY(), 1, nepriatel, veza));
    }
    
    /**
     * Každá strela v ArrayListe vystrelí na nepriateľa
     */
    public void vsetkyVezickyStrielajteNaNepriatela() {
        for (Strela strela : this.zoznamStriel) {
            strela.strielajNaNepriatela();
        }
    }
}
