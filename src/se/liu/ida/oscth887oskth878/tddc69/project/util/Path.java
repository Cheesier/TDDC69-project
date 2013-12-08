package se.liu.ida.oscth887oskth878.tddc69.project.util;

import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Tile;

import java.util.LinkedList;

/**
 * Contains the entire path for a <code>Unit</code> to get to the endpoint
 *
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 30/09/2013
 */
public class Path {
    private LinkedList<Pointf> path = new LinkedList<Pointf>();

    public void addPoint(int x, int y) {
        path.add(new Pointf(x + Tile.HALF_TILE, y + Tile.HALF_TILE)); // add .5 to location to get center of tile
    }

    public Pointf next() {
        return path.peek();
    }

    public void removeLast() {
        path.remove();
    }

    public boolean hasNext() {
        return !path.isEmpty();
    }

    public int length() {
        return path.size();
    }
}
