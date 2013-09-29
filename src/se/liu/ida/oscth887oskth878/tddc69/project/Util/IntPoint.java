package se.liu.ida.oscth887oskth878.tddc69.project.Util;

/**
 * @version 1.0
 * @author: Oskar Therén
 * @author: Oscar Thunberg
 * @since: 29/09/2013
 */
public class IntPoint {
    public int x, y;

    public IntPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public String toString() {
        return "{" + x + ", " + y + "}";
    }
}
