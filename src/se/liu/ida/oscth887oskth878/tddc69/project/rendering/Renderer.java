package se.liu.ida.oscth887oskth878.tddc69.project.rendering;

import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Level;

/**
 * Interface to implement all the different ways of rendering the game.
 *
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 27/09/2013
 */
public interface Renderer {

    public void init(int screenWidth, int screenHeight);
    public void drawLevel(Level level); // we only want to render one level
    public void drawUI();

}
