package se.liu.ida.oscth887oskth878.tddc69.project.Client.input;

import se.liu.ida.oscth887oskth878.tddc69.project.Client.Client;

/**
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 30/09/2013
 */
public class MouseClickEvent {
    public static enum Location {
        GUI, TILE
    }

    private boolean state;
    private int x;
    private int y;
    private Location location;

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
