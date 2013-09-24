package se.liu.ida.oscth887oskth878.tddc69.project.Util;

/**
 * Created with IntelliJ IDEA.
 * User: Oscar
 * Date: 2013-09-15
 * Time: 20:48
 */
public class Point {
    public float x, y;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "{" + x + ", " + y + "}";
    }
}
