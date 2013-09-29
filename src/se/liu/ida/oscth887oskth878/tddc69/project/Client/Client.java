package se.liu.ida.oscth887oskth878.tddc69.project.Client;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import se.liu.ida.oscth887oskth878.tddc69.project.Rendering.GLBegin;
import se.liu.ida.oscth887oskth878.tddc69.project.Rendering.Renderer;
import se.liu.ida.oscth887oskth878.tddc69.project.Simulation.Level;
import se.liu.ida.oscth887oskth878.tddc69.project.Simulation.TowerFactory;


public class Client {
    public static final int SIZE = 32;

    public static void main(String[] args) {
        Renderer renderer = new GLBegin();
        Level level = new Level(43, 20);

        /*GameClient server = new GameClient();

        try {
            Thread.sleep(10000l);
            server.close("End of game");
        } catch (InterruptedException e) {
        }
        */

        try {
            Display.setDisplayMode(new DisplayMode(43* SIZE, 20* SIZE));
            Display.create();

            Display.setTitle("OTD game");
        } catch (LWJGLException e) {
            e.printStackTrace();
        }

        renderer.init(43*SIZE, 20*SIZE, SIZE);
        level.generateBasicLevel();

        int frames = 0;
        long lastTime = System.nanoTime();

        while (!Display.isCloseRequested()) {
            try {
                Display.swapBuffers();
            } catch (LWJGLException e) {
                e.printStackTrace();
            }
            renderer.draw(level);


            frames ++;
            if (System.nanoTime()-lastTime > 1000000000) {
                System.out.println(frames);
                frames = 0;
                lastTime = System.nanoTime();
            }
            Display.update();
            Display.sync(20);

            //Display.setVSyncEnabled(true);
        }
        Display.destroy();
        System.exit(0);

        /* PREPARATIONS FOR GAMELOOP


        const int TICKS_PER_SECOND = 25;
        const int SKIP_TICKS = 1000 / TICKS_PER_SECOND;
        const int MAX_FRAMESKIP = 5;

        DWORD next_game_tick = GetTickCount();
        int loops;
        float interpolation;

        bool game_is_running = true;
        while( game_is_running ) {

            loops = 0;
            while( GetTickCount() > next_game_tick && loops < MAX_FRAMESKIP) {
                update_game();

                next_game_tick += SKIP_TICKS;
                loops++;
            }

            interpolation = float( GetTickCount() + SKIP_TICKS - next_game_tick )
                            / float( SKIP_TICKS );
            display_game( interpolation );
        }
         */
    }
}
