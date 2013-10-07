package se.liu.ida.oscth887oskth878.tddc69.project.client;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import se.liu.ida.oscth887oskth878.tddc69.project.client.input.MouseHandler;
import se.liu.ida.oscth887oskth878.tddc69.project.input.InputManager;
import se.liu.ida.oscth887oskth878.tddc69.project.rendering.GLBegin;
import se.liu.ida.oscth887oskth878.tddc69.project.rendering.Renderer;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Level;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Player;


public class Client {
    public static final int PIXELS_PER_TILE = 32;
    public static final int WIDTH = 43;
    public static final int HEIGHT = 20;
    public static final int UI_SIZE = PIXELS_PER_TILE * 2;
    public static final Level level = new Level(WIDTH, HEIGHT);
    public static final Player player = new Player(Player.Team.RED, "Ost");

    public static void main(String[] args) {
        Renderer renderer = new GLBegin();

        /*GameClient server = new GameClient();

        try {
            Thread.sleep(10000l);
            server.close("End of game");
        } catch (InterruptedException e) {
        }
        */

        try {
            Display.setDisplayMode(new DisplayMode(WIDTH* PIXELS_PER_TILE, HEIGHT * PIXELS_PER_TILE + UI_SIZE));
            Display.create();

            Display.setTitle("OTD game");
        } catch (LWJGLException e) {
            e.printStackTrace();
        }

        renderer.init(WIDTH* PIXELS_PER_TILE, HEIGHT * PIXELS_PER_TILE + UI_SIZE, PIXELS_PER_TILE);
        level.generateBasicLevel();

        int frames = 0;
        long lastTime = System.nanoTime();

        InputManager.addListener(new EventHandler());

        while (!Display.isCloseRequested()) {
            MouseHandler.update();

            //try { Display.swapBuffers(); } catch (LWJGLException e) { e.printStackTrace(); }

            level.tick();

            renderer.drawLevel(level);
            renderer.drawUI();


            frames ++;
            if (System.nanoTime()-lastTime > 1000000000) {
                //System.out.println(frames);
                frames = 0;
                lastTime = System.nanoTime();
            }
            Display.update();
            Display.sync(20);
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
