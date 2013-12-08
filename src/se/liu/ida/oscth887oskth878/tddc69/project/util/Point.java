package se.liu.ida.oscth887oskth878.tddc69.project.util;

/**
 * Represents an interger Point in 2d space.
 *
 * @author Oskar Therén
 * @author Oscar Thunberg
 * @version 1.0
 * @since 29/09/2013
 */
public class Point {
    public int x, y;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pointf toPointf() {
        return new Pointf(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point) {
            Point other = (Point)obj;
            return x == other.x && y == other.y;
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return 101 * x*x + y;
    }

    @Override
    public String toString() {
        return "{" + x + ", " + y + "}";
    }
}
