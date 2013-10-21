package se.liu.ida.oscth887oskth878.tddc69.project.client.input;

import se.liu.ida.oscth887oskth878.tddc69.project.client.Client;
import se.liu.ida.oscth887oskth878.tddc69.project.util.Point;

/**
 * Translates pixel coordinates to a <code>Tile</code> or <code>GUI</code> coordinate.
 *
 * @author Oskar Therén
 * @author Oscar Thunberg
 * @version 1.0
 * @since 29/09/2013
 */
public class MouseTranslator {

    public static Point getTile(int x, int y) {
        return new Point(x / Client.PIXELS_PER_TILE, (y - Client.UI_SIZE) / Client.PIXELS_PER_TILE);
    }

    public static Point getGui(int x, int y) {
        return new Point(x / Client.UI_SIZE , y / Client.PIXELS_PER_TILE);
    }

}
