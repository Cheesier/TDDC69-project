package se.liu.ida.oscth887oskth878.tddc69.project.client;

import se.liu.ida.oscth887oskth878.tddc69.project.client.input.MouseHandler;
import se.liu.ida.oscth887oskth878.tddc69.project.input.InputManager;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Level;

/**
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 07/10/2013
 */
public class Game {
    public static final int WIDTH = 43;
    public static final int HEIGHT = 20;
    public static final Level level = new Level(WIDTH, HEIGHT);


    public static void init() {
        level.generateBasicLevel();
        InputManager.addListener(new EventHandler());
    }

    public static void tick() {
        MouseHandler.update();

        level.tick();
    }
}
