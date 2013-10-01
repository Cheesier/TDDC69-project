package se.liu.ida.oscth887oskth878.tddc69.project.simulation;

import se.liu.ida.oscth887oskth878.tddc69.project.util.Dimension;
import se.liu.ida.oscth887oskth878.tddc69.project.util.Point;

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
    public void generateBasicLevel() {
        for (int x = 0; x < dimensions.x; x++) {
            for (int y = 0; y < dimensions.y; y++) {
                this.setTile(x, y, new Tile(Tile.UnitMobility.ALL, true, Tile.Type.GRASS));
            }
        }

        getTile(10, 10).buildTower(TowerFactory.TowerType.BASIC_TOWER);
    }

    public Tile getTile(int x, int y) {
        if (x < 0 || x > dimensions.x || y < 0 || y > dimensions.y)
            return null;
        return tileGrid[x][y];
    }

    public Tile getTile(Point point) {
        return getTile(point.x, point.y);
    }

    public boolean canPass(int x, int y, Unit unit) {
        return getTile(x, y).canPass(unit);
    }

    public void setTile(int x, int y, Tile tile) {
        tileGrid[x][y] = tile;
    }

    public Dimension getDimensions() {
        return dimensions;
    }
}
