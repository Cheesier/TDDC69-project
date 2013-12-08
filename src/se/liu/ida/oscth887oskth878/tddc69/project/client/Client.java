package se.liu.ida.oscth887oskth878.tddc69.project.client;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import se.liu.ida.oscth887oskth878.tddc69.project.client.input.MouseHandler;
import se.liu.ida.oscth887oskth878.tddc69.project.network.Network;
import se.liu.ida.oscth887oskth878.tddc69.project.network.client.GameClient;
import se.liu.ida.oscth887oskth878.tddc69.project.rendering.GLBegin;
import se.liu.ida.oscth887oskth878.tddc69.project.rendering.Renderer;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Player;

import javax.swing.*;

/**
 * The local client settings and initialization of the game.
 *
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 15/09/2013
 */
public final class Client {
    public static final int PIXELS_PER_TILE = 32;
    public static final int UI_SIZE = PIXELS_PER_TILE * 2;
    public static Player player = new Player();
    public static GameClient server;
    private static final int framerate = 20;

    private Client() {
    }

    public static void main(String[] args) {
        Renderer renderer = new GLBegin();

        String name = JOptionPane.showInputDialog("Player name: ");
        String address = JOptionPane.showInputDialog("Server IP: ", "localhost:"+ Network.DEFAULT_PORT);

        if (name.isEmpty())
            name = "Newbie";

        int port = Integer.parseInt(address.substring(address.indexOf(':')+1, address.length()));

        server = new GameClient(address.substring(0, address.indexOf(':')), port);
        server.handshake(name);


        try {
            Display.setDisplayMode(new DisplayMode(Game.WIDTH* PIXELS_PER_TILE, Game.HEIGHT * PIXELS_PER_TILE + UI_SIZE));
            Display.create();

            Display.setTitle("OTD game (" + name + ")");
        } catch (LWJGLException e) {
            e.printStackTrace();
        }

        renderer.init(Game.WIDTH* PIXELS_PER_TILE, Game.HEIGHT * PIXELS_PER_TILE + UI_SIZE);

        Game.init();

        while (!Display.isCloseRequested()) {
            server.update();
            MouseHandler.update();
            Game.tick();

            renderer.drawLevel(Game.level);
            renderer.drawUI();

            Display.update();
            Display.sync(framerate);
        }
        server.close("Closing client");
        Display.destroy();
        System.exit(0);
    }
}
