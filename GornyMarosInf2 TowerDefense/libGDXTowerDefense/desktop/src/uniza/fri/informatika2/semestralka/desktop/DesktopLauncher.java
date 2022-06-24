package uniza.fri.informatika2.semestralka.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import uniza.fri.informatika2.semestralka.TowerDefense;

public class DesktopLauncher {

    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

        config.title = "TowerDefense";
        config.width = 400;
        config.height = 400;
        config.resizable = false;
        config.fullscreen = false;

        new LwjglApplication(new TowerDefense(), config);

    }
}
