package se.liu.ida.oscth887oskth878.tddc69.project.util;

/**
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 15/09/2013
 */
public class Pointf {
    public float x, y;

    public Pointf() {
    }

    public Pointf(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Pointf add(float x, float y) {
        this.x += x;
        this.y += y;
        return this;
    }

    public Pointf mul(float x, float y) {
        this.x *= x;
        this.y *= y;
        return this;
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
