package se.liu.ida.oscth887oskth878.tddc69.project.rendering;

import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Level;

/**
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 27/09/2013
 */
public interface Renderer {

    public void init(int screenWidth, int screenHeight);
    public void drawLevel(Level level);
    public void drawUI();

}
