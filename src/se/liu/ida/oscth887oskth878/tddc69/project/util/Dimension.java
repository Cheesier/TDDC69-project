package se.liu.ida.oscth887oskth878.tddc69.project.util;

/**
 * Created with IntelliJ IDEA.
 * User: Oscar
 * Date: 2013-09-15
 * Time: 22:25
 */
public class Dimension {
    public final int x;
    public final int y;

    public Dimension(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "{" + x + ", " + y + "}";
    }
}
