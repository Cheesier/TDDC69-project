package se.liu.ida.oscth887.oskth878.tddc69.project.Simulation;

import se.liu.ida.oscth887.oskth878.tddc69.project.Util.Vec2;

/**
 * Created with IntelliJ IDEA.
 * User: Oscar
 * Date: 2013-09-15
 * Time: 20:47
 */
public class Level {
    private Tile[][] tileGrid;

    private Vec2 dimensions;

    public Level(int x, int y) {
        tileGrid = new Tile[x][y];
        dimensions = new Vec2(x, y);
    }
}
