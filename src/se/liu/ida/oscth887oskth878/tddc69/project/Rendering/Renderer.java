package se.liu.ida.oscth887oskth878.tddc69.project.Rendering;

import se.liu.ida.oscth887oskth878.tddc69.project.Simulation.Level;

/**
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 27/09/2013
 */
public interface Renderer {

    public void init(int width, int height, int size);
    public void drawLevel(Level level);
    public void drawUI();

}
