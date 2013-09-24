package se.liu.ida.oscth887oskth878.tddc69.project.Simulation;

import se.liu.ida.oscth887oskth878.tddc69.project.Util.Dimension;

/**
 * Created with IntelliJ IDEA.
 * User: Oscar
 * Date: 2013-09-15
 * Time: 20:47
 */
public class Level {
    private Tile[][] tileGrid;

    private Dimension dimensions;

    public Level(int x, int y) {
        tileGrid = new Tile[x][y];
        dimensions = new Dimension(x, y);
    }

    // should not be shipped with release version
    // just for development
    public static Level generateBasicLevel() {
        Dimension dim = new Dimension(41, 20);
        Level level = new Level(dim.x, dim.y);
        for (int x = 0; x < dim.x; x++) {
            for (int y = 0; y < dim.y; y++) {
                level.setTile(x, y, new Tile(Tile.UnitMobility.ALL, true, Tile.Type.GRASS));
            }
        }
        return level;
    }

    public Tile getTile(int x, int y) {
        return tileGrid[x][y];
    }

    public boolean canPass(int x, int y, Unit unit) {
        return getTile(x, y).canPass(unit);
    }

    public void setTile(int x, int y, Tile tile) {

    }

    public Dimension getDimensions() {
        return dimensions;
    }
}
