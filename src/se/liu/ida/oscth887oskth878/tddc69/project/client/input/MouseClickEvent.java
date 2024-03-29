package se.liu.ida.oscth887oskth878.tddc69.project.client.input;

import se.liu.ida.oscth887oskth878.tddc69.project.client.Client;

/**
 * Event to pass to listeners.
 *
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 30/09/2013
 */
public class MouseClickEvent {
    public static enum Location {
        GUI, TILE
    }

    private final boolean state;
    private final int x;
    private final int y;
    private final Location location;

    public MouseClickEvent(boolean state, int x, int y) {
        this.state = state;
        this.x = x;
        this.y = y;

        if (y < Client.UI_SIZE)
            this.location = Location.GUI;
        else
            this.location = Location.TILE;
    }

    public boolean getState() {
        return state;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Location getLocation() {
        return location;
    }
}
