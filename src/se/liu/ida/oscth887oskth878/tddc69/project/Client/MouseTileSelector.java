package se.liu.ida.oscth887oskth878.tddc69.project.Client;

import org.lwjgl.input.Mouse;
import se.liu.ida.oscth887oskth878.tddc69.project.Util.IntPoint;

/**
 * @version 1.0
 * @author: Oskar Therén
 * @author: Oscar Thunberg
 * @since: 29/09/2013
 */
public class MouseTileSelector {
    static IntPoint mousePosition;

    public static IntPoint getTile() {
        int x = Mouse.getX() / Client.PIXELS_TILE;
        int y = Mouse.getY() / Client.PIXELS_TILE;

        return new IntPoint(x, y);
    }


}
