package se.liu.ida.oscth887oskth878.tddc69.project.Client.input;

import org.lwjgl.input.Mouse;
import se.liu.ida.oscth887oskth878.tddc69.project.Client.Client;
import se.liu.ida.oscth887oskth878.tddc69.project.Util.Point;

/**
 * @version 1.0
 * @author: Oskar Therén
 * @author: Oscar Thunberg
 * @since: 29/09/2013
 */
public class MouseTranslator {
    static Point mousePosition;

    public static Point getTile(int x, int y) {
        return new Point(x / Client.PIXELS_PER_TILE, (y - Client.UI_SIZE) / Client.PIXELS_PER_TILE);
    }

    public static Point getGui(int x, int y) {
        return new Point(x / Client.UI_SIZE , y / Client.PIXELS_PER_TILE);
    }

}