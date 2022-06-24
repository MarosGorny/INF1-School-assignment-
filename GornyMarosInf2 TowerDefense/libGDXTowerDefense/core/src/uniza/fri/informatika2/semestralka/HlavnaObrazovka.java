/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniza.fri.informatika2.semestralka;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import uniza.fri.informatika2.semestralka.nepriatel.Cerveny;
import uniza.fri.informatika2.semestralka.nepriatel.Modry;
import uniza.fri.informatika2.semestralka.nepriatel.TovarnaNaNepriatelov;
import uniza.fri.informatika2.semestralka.nepriatel.Tyrkysovy;
import uniza.fri.informatika2.semestralka.nepriatel.Zeleny;
import uniza.fri.informatika2.semestralka.nepriatel.Zlty;
import veze.Dvojka;
import veze.Jednotka;
import veze.Patka;
import veze.Stvorka;
import veze.Trojka;
import veze.Veza;
import veze.VezickyNaMape;

/**
 *
 * @author Gorný Maroš
 */
public class HlavnaObrazovka extends ScreenAdapter {

    private SpriteBatch batch;
    private Texture img;

    private TovarnaNaNepriatelov tovarna;
    private VezickyNaMape vezicky;
    private Mechanika mechanika;

    private int pocitadloCasu;
    private int zivoty;

    private Veza veza;

    @Override

    public void show() {
        this.batch = new SpriteBatch();
    }
    
    /**
     * Konštruktor triedy HlavnaObrazovka, vytvorí pozadie, triedy : Mechanika,
     * TovarenNaNepriatelov, VezickyNaMape Pocitadlo času nastaví na 1 a životy
     * na 3
     */
    public HlavnaObrazovka() {
        this.img = new Texture(Gdx.files.internal("pozadie.png"));

        this.mechanika = new Mechanika();

        this.tovarna = new TovarnaNaNepriatelov();
        this.vezicky = new VezickyNaMape();

        this.pocitadloCasu = 0;
        this.zivoty = 3;
    }

    
    /**
     * Render skopíruje sa ArrayList Nepriatelov z TovarnaNaNepriatelov
     * Skopiruje sa ArrayList Striel zo StrelyNaMape
     *
     * Podľa aktuálneho levelu sa pustí nová vlna nepriateľov
     *
     * Počítadlo času sa inkrementuje
     *
     * Pohne s vežičkami Pohne so strelami
     *
     * Kontroluje kolíziu striel s nepriateľmi Kontroluje akú vežičku má na mapu
     * pridať Kontroluje, či môžem pridať vežičku na dané miesto, ak áno vežičku
     * pridá odobere peniaze za danú vežičku Kontroluje, či nepriateľ prešiel
     * cez ciel, ak prešlo viac nepriateľov ako je možné tak hru ukončí
     *
     * Vymaže mŕtvych nepriateľov Vymaže strely ktoré mali kolíziu s nepriateľom
     *
     * Pridá peniaze za zabitého nepriateľa
     *
     * Každých 60 krát renderu vežičky vystrelia
     *
     * Ak je počítadlo vysoké tak sa zresetuje
     *
     * Čaká na pustenie nového levelu
     *
     * Vykreslí Nepriateľov, Vežičky, Strely, 
     *         obrázok Mincí, Životov, Vežičky na výber, Šípku, Čísla mincí 
     */
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(255, 255, 255, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        this.vezicky.skopirujArNepriatelov(this.tovarna.dajAktNep());
        this.vezicky.skopirujArStriel();

        if (this.mechanika.getLevel() == 0) {
            this.tovarna.vytvorVlnuNepriatelov(new Cerveny());
        }

        if (this.mechanika.getLevel() == 1) {
            this.tovarna.vytvorVlnuNepriatelov(new Modry());
        }

        if (this.mechanika.getLevel() == 2) {
            this.tovarna.vytvorVlnuNepriatelov(new Tyrkysovy());
        }

        if (this.mechanika.getLevel() == 3) {
            this.tovarna.vytvorVlnuNepriatelov(new Zeleny());
        }

        if (this.mechanika.getLevel() == 4) {
            this.tovarna.vytvorVlnuNepriatelov(new Zlty());
        }

        this.pocitadloCasu++;

        this.tovarna.cestujteVsetciVTovarni();
        this.vezicky.strelyHybteSa();
        this.vezicky.kolizieStriel(this.batch);

        this.tovarna.vymazMrtvychNepriatelov();
        if (this.tovarna.getMrtvyNepriatel() != null) {
            this.mechanika.pridajPeniaze(this.tovarna.getMrtvyNepriatel());
        }

        this.vezicky.vymazMrtveStrely();

        if (this.pocitadloCasu % 60 == 0) {
            this.vezicky.vezickyStrielajte();
        }

        if (this.pocitadloCasu > 6000000) {
            this.pocitadloCasu = 0;
        }

        if (Gdx.input.justTouched()) {
            if (this.vezicky.mozemPridatVezicku(Gdx.input.getX(), Gdx.input.getY())) {
                if (!this.vezicky.uzExistujeVezicka(Gdx.input.getX(), Gdx.input.getY())) {
                    if (this.veza != null) {
                        this.vezicky.pridajVezicku(this.veza.vytvorVezicku());
                        this.mechanika.odoberPeniaze(this.veza);
                        this.veza = null;
                    }
                }
            }

            if (Gdx.input.getX() - (Gdx.input.getX() % 40) == 360 && Gdx.input.getY() - (Gdx.input.getY() % 40) == 360) {
                if (this.tovarna.sizeNepriatelov() == 0) {
                    this.mechanika.pridajLevel();
                    this.tovarna.resetPocitadloCasu();
                }
            }
            int pomocnyModusX = Gdx.input.getX() - (Gdx.input.getX() % 40);
            int pomocnyModusY = Gdx.input.getY() - (Gdx.input.getY() % 40);

            if (pomocnyModusX == 360) {
                switch (pomocnyModusY) {
                    case 40:
                        this.veza = new Jednotka(Gdx.input.getX(), Gdx.input.getY());
                        break;
                    case 80:
                        this.veza = new Dvojka(Gdx.input.getX(), Gdx.input.getY());
                        break;
                    case 120:
                        this.veza = new Trojka(Gdx.input.getX(), Gdx.input.getY());
                        break;
                    case 160:
                        this.veza = new Stvorka(Gdx.input.getX(), Gdx.input.getY());
                        break;
                    case 200:
                        this.veza = new Patka(Gdx.input.getX(), Gdx.input.getY());
                        break;
                    default:
                        this.veza = null;
                        break;
                }
            } else {
                this.veza = null;
            }
        }

        if (this.tovarna.presielCezCiel()) {
            this.zivoty--;           
            if (this.zivoty <= 0) {
                System.exit(0);
            }
        }

        this.batch.begin();
        this.batch.draw(this.img, 0, 0);

        this.tovarna.vykresliVsetkychNepriatelov(this.batch);

        this.vezicky.vykresliVezicky(this.batch);
        this.vezicky.vykresliKazduStrelu(this.batch);

        this.mechanika.vykresliCoins(this.batch);
        this.mechanika.vykresliSeletcedVezicky(this.batch);
        this.mechanika.vykresliZivoty(this.batch, this.zivoty);
        if (this.tovarna.sizeNepriatelov() == 0) {
            this.mechanika.vykresliNext(this.batch);
        }
        this.mechanika.vykresliCisla(this.batch);

        this.batch.end();
    }

    @Override
    public void dispose() {
        this.batch.dispose();
        this.img.dispose();
    }
}
