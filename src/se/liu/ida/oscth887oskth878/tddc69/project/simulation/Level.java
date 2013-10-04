package se.liu.ida.oscth887oskth878.tddc69.project.simulation;

import se.liu.ida.oscth887oskth878.tddc69.project.util.Dimension;
import se.liu.ida.oscth887oskth878.tddc69.project.util.Point;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: Oscar
 * Date: 2013-09-15
 * Time: 20:47
 */
public class Level {
    private Tile[][] tileGrid;
    private ArrayList<Unit> units = new ArrayList<Unit>();

    private Dimension dimensions;

    public Level(int x, int y) {
        tileGrid = new Tile[x][y];
        dimensions = new Dimension(x, y);
    }

    public void tick() {
        Iterator<Unit> itr = units.iterator();

        while (itr.hasNext()) {
            itr.next().tick();
        }
    }

    // should not be shipped with release version
    // just for development
    public void generateBasicLevel() {
        for (int x = 0; x < dimensions.x; x++) {
            for (int y = 0; y < dimensions.y; y++) {
                this.setTile(x, y, new Tile(Tile.UnitMobility.ALL, true, Tile.Type.GRASS));
            }
        }


        getTile(11, 10).buildTower(TowerFactory.TowerType.BASIC_TOWER); // TODO: Remove debug code
        getTile(11, 11).buildTower(TowerFactory.TowerType.BASIC_TOWER);
        getTile(11, 9).buildTower(TowerFactory.TowerType.BASIC_TOWER);
        getTile(12, 9).buildTower(TowerFactory.TowerType.BASIC_TOWER);
        getTile(12, 11).buildTower(TowerFactory.TowerType.BASIC_TOWER);
        spawnUnit(Player.Team.BLUE);
    }

    public Tile getTile(int x, int y) {
        if (x < 0 || x >= dimensions.x || y < 0 || y >= dimensions.y)
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

    public void spawnUnit(Player.Team team) {
        Unit unit = UnitFactory.getUnit(UnitFactory.UnitType.BASIC_UNIT, team);
        unit.generatePath(new Point(12, 10), this);
        units.add(unit);
    }

    public Iterator<Unit> getUnitIterator() {
        return units.iterator();
    }
}
