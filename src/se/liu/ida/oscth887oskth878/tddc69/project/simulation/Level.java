package se.liu.ida.oscth887oskth878.tddc69.project.simulation;

import se.liu.ida.oscth887oskth878.tddc69.project.util.Dimension;
import se.liu.ida.oscth887oskth878.tddc69.project.util.Point;
import se.liu.ida.oscth887oskth878.tddc69.project.util.Pointf;

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

    private Point redSpawn;
    private Point blueSpawn;
    private Point redPortal;
    private Point bluePortal;

    public Level(int x, int y) {
        tileGrid = new Tile[x][y];
        dimensions = new Dimension(x, y);

        redSpawn = new Point(dimensions.x/2, dimensions.y/2);
        blueSpawn = new Point(dimensions.x/2 + 1, dimensions.y/2);
        redPortal = new Point(0, dimensions.y/2);
        bluePortal = new Point(dimensions.x - 1, dimensions.y/2);
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
                this.setTile(x, y, new Tile(Tile.UnitMobility.ALL, true, Tile.Type.GRASS, Player.Team.NEUTRAL));
            }
        }

        setTile(redSpawn.x, redSpawn.y, new Tile(Tile.UnitMobility.ALL, false, Tile.Type.SPAWN, Player.Team.RED));
        setTile(blueSpawn.x, blueSpawn.y, new Tile(Tile.UnitMobility.ALL, false, Tile.Type.SPAWN, Player.Team.BLUE));
        setTile(redPortal.x, redPortal.y, new Tile(Tile.UnitMobility.ALL, false, Tile.Type.PORTAL, Player.Team.RED));
        setTile(bluePortal.x, bluePortal.y, new Tile(Tile.UnitMobility.ALL, false, Tile.Type.PORTAL, Player.Team.BLUE));


        getTile(11, 10).buildTower(TowerFactory.TowerType.BASIC_TOWER); // TODO: Remove debug code
        getTile(11, 11).buildTower(TowerFactory.TowerType.BASIC_TOWER);
        getTile(11, 9).buildTower(TowerFactory.TowerType.BASIC_TOWER);
        getTile(12, 9).buildTower(TowerFactory.TowerType.BASIC_TOWER);
        getTile(12, 11).buildTower(TowerFactory.TowerType.BASIC_TOWER);
        spawnUnit(Player.Team.BLUE);
        spawnUnit(Player.Team.RED);
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
        Unit unit = UnitFactory.getUnit(UnitFactory.UnitType.BASIC_UNIT, team, getSpawnTile(team));
        unit.generatePath(getPortalTile(team), this);
        units.add(unit);
    }

    public Iterator<Unit> getUnitIterator() {
        return units.iterator();
    }

    public Pointf getSpawnTile(Player.Team owner) {
        Pointf spawn;
        switch (owner) {
            case BLUE:
                spawn = blueSpawn.toPointf();
                break;
            case RED:
                spawn = redSpawn.toPointf();
                break;
            default:
                throw new RuntimeException("Not a valid team");
        }
        spawn.add(0.5f, 0.5f);
        return spawn;
    }

    public Pointf getPortalTile(Player.Team owner) {
        switch (owner) {
            case BLUE:
                return bluePortal.toPointf();
            case RED:
                return redPortal.toPointf();
            default:
                throw new RuntimeException("Not a valid team");
        }
    }

}
