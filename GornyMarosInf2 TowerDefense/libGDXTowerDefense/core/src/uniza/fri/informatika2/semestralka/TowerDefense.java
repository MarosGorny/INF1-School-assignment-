package uniza.fri.informatika2.semestralka;


import com.badlogic.gdx.Game;


public class TowerDefense extends Game {
    
    /**
     * Vytvorí Hlavnú obrazovku
     */
    @Override
    public void create() {
        setScreen(new HlavnaObrazovka());
    }

   
}
