package se.liu.ida.oscth887oskth878.tddc69.project.util;

/**
 * Created with IntelliJ IDEA.
 * User: Oscar
 * Date: 2013-09-15
 * Time: 20:48
 */
public class Pointf {
    public float x, y;

    public Pointf(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void add(float x, float y) {
        this.x += x;
        this.y += y;
    }

    public void mul(float x, float y) {
        this.x *= x;
        this.y *= y;
    }
    public double distance(Pointf other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }

    public Point toPoint() {
        return new Point((int)x, (int)y);
    }

    @Override
    public String toString() {
        return "{" + x + ", " + y + "}";
    }
}
