package se.liu.ida.oscth887oskth878.tddc69.project.util;

/**
 * @author Oskar Therén
 * @author Oscar Thunberg
 * @version 1.0
 * @since 29/09/2013
 */
public class Point {
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void add(int x, float y) {
        this.x += x;
        this.y += y;
    }

    public void mul(float x, float y) {
        this.x *= x;
        this.y *= y;
    }

    public Pointf toPointf() {
        return new Pointf(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point)
            return equals((Point) obj);
        return super.equals(obj);
    }

    public boolean equals(Point obj) {
        return x == obj.x && y == obj.y;
    }

    @Override
    public int hashCode() {
        return 101 *
                x*x + y;
    }

    @Override
    public String toString() {
        return "{" + x + ", " + y + "}";
    }
}
