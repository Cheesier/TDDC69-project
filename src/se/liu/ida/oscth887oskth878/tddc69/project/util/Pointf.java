package se.liu.ida.oscth887oskth878.tddc69.project.util;

/**
 * Represents a float Point in 2d space.
 *
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 15/09/2013
 */
public class Pointf {
    public float x, y;

    public Pointf() {
    }

    public Pointf(float xVal, float yVal) {
        this.x = xVal;
        this.y = yVal;
    }

    public void add(float xVal, float yVal) {
        this.x += xVal;
        this.y += yVal;
    }

    public double distance(Pointf other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }

    @Override
    public String toString() {
        return "{" + x + ", " + y + "}";
    }
}
