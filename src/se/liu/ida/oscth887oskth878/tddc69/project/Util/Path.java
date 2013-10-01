package se.liu.ida.oscth887oskth878.tddc69.project.util;

import java.util.LinkedList;

/**
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 30/09/2013
 */
public class Path {
    private LinkedList<Point> path = new LinkedList<Point>();

    public Point next() {
        return path.remove();
    }
}
