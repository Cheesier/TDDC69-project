package se.liu.ida.oscth887oskth878.tddc69.project.client;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import se.liu.ida.oscth887oskth878.tddc69.project.client.input.MouseHandler;
import se.liu.ida.oscth887oskth878.tddc69.project.network.client.GameClient;
import se.liu.ida.oscth887oskth878.tddc69.project.rendering.GLBegin;
import se.liu.ida.oscth887oskth878.tddc69.project.rendering.Renderer;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Player;

/**
 * The local client settings and initialization of the game.
 *
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 15/09/2013
 */
public class Client {
    public static final int PIXELS_PER_TILE = 32;
    public static final int UI_SIZE = PIXELS_PER_TILE * 2;
    public static Player player = new Player();
    public static GameClient server;

    public static void main(String[] args) {
        Renderer renderer = new GLBegin();

        server = new GameClient();


        try {
            Display.setDisplayMode(new DisplayMode(Game.WIDTH* PIXELS_PER_TILE, Game.HEIGHT * PIXELS_PER_TILE + UI_SIZE));
            Display.create();

            Display.setTitle("OTD game");
        } catch (LWJGLException e) {
            e.printStackTrace();
        }

        renderer.init(Game.WIDTH* PIXELS_PER_TILE, Game.HEIGHT * PIXELS_PER_TILE + UI_SIZE);

        int frames = 0;
        long lastTime = System.nanoTime();

        Game.init();

        while (!Display.isCloseRequested()) {
            server.update();
            MouseHandler.update();
            Game.tick();

            renderer.drawLevel(Game.level);
            renderer.drawUI();


            // simple, relatively accurate fps counter
            /*
            frames ++;
            if (System.nanoTime()-lastTime > 1000000000) {
                System.out.println(frames);
                frames = 0;
                lastTime = System.nanoTime();
            }
            */

            Display.update();
            Display.sync(20);
        }
        server.close("Closing client");
        Display.destroy();
        System.exit(0);
    }
}
