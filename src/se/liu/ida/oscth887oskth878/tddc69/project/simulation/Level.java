package se.liu.ida.oscth887oskth878.tddc69.project.simulation;

import se.liu.ida.oscth887oskth878.tddc69.project.simulation.towers.SpawnTower;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.units.BasicUnit;
import se.liu.ida.oscth887oskth878.tddc69.project.util.Dimension;
import se.liu.ida.oscth887oskth878.tddc69.project.util.Point;
import se.liu.ida.oscth887oskth878.tddc69.project.util.Pointf;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Oscar
 * Date: 2013-09-15
 * Time: 20:47
 */
public class Level {
    private Tile[][] tileGrid;
    private ArrayList<Unit> units = new ArrayList<Unit>();
    private Hashtable<Point, Tower> towers = new Hashtable<Point, Tower>();

    private Dimension dimensions;

    private Point redSpawn;
    private Point blueSpawn;
    private Point redPortal;
    private Point bluePortal;

    public Level(int x, int y) {
        tileGrid = new Tile[x][y];
        dimensions = new Dimension(x, y);

        redSpawn = new Point(dimensions.x/2, dimensions.y/2);
        blueSpawn = new Point(dimensions.x/2+1, dimensions.y/2);
        redPortal = new Point(0, dimensions.y/2);
        bluePortal = new Point(dimensions.x - 1, dimensions.y/2);
    }

    public void tick() {
        Iterator<Unit> unitItrator = units.iterator();

        Iterator<Map.Entry<Point, Tower>> towerIterator = towers.entrySet().iterator();

        while (towerIterator.hasNext()) {
            Map.Entry<Point, Tower> entry = towerIterator.next();
            entry.getValue().tick(entry.getKey(), units.iterator());
        }

        while (unitItrator.hasNext()) {
            Unit unit = unitItrator.next();
            if (!unit.tick()) {
                unitItrator.remove();
            }
        }

    }

    public boolean pathNotBlocked(Player.Team team) {
        spawnUnit(UnitFactory.UnitType.BASIC_UNIT, Player.getEnemy(team));
        boolean ground = units.get(units.size()-1).generatePath(getPortalTile(Player.getEnemy(team)), this);
        units.remove(units.size()-1);

        spawnUnit(UnitFactory.UnitType.BASIC_FLYING, Player.getEnemy(team));
        boolean air = units.get(units.size()-1).generatePath(getPortalTile(Player.getEnemy(team)), this);
        units.remove(units.size()-1);

        return ground && air;
    }

    public void updateAllPaths() {
        Iterator<Unit> unitIterator = units.iterator();

        while (unitIterator.hasNext()) {
            Unit unit = unitIterator.next();
            unit.generatePath(getPortalTile(unit.getOwner()), this);
        }
    }

    // should not be shipped with release version
    // just for development
    public void generateBasicLevel() {
        for (int x = 0; x < dimensions.x; x++) {
            for (int y = 0; y < dimensions.y; y++) {
                if (x > dimensions.x / 2 + 1)
                    this.setTile(x, y, new Tile(Tile.UnitMobility.ALL, true, Tile.Type.GRASS, Player.Team.BLUE));
                else if (x < dimensions.x / 2)
                    this.setTile(x, y, new Tile(Tile.UnitMobility.ALL, true, Tile.Type.GRASS, Player.Team.RED));
                else
                    this.setTile(x, y, new Tile(Tile.UnitMobility.ALL, true, Tile.Type.GRASS, Player.Team.NEUTRAL));
            }
        }

        getTile(redSpawn).buildTower(TowerFactory.TowerType.SPAWN, Player.Team.NEUTRAL);
        getTile(redPortal).buildTower(TowerFactory.TowerType.PORTAL, Player.Team.NEUTRAL);

        getTile(blueSpawn).buildTower(TowerFactory.TowerType.SPAWN, Player.Team.NEUTRAL);
        getTile(bluePortal).buildTower(TowerFactory.TowerType.PORTAL, Player.Team.NEUTRAL);
    }

    private Tile getTile(int x, int y) {
        if (x < 0 || x >= dimensions.x || y < 0 || y >= dimensions.y)
            return null;
        return tileGrid[x][y];
    }

    private Tile getTile(Point point) {
        return getTile(point.x, point.y);
    }

    public Tile.Type getTileType(int x, int y) {
        if (getTile(x, y) != null)
            return getTile(x, y).getType();
        return null;
    }

    public Player.Team getTileOwner(int x, int y) {
        if (getTile(x, y) != null)
            return getTile(x, y).getOwner();
        return null;
    }

    public Tower getTower(int x, int y) {
        return getTile(x, y).getTower();
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

    public void buildTower(int x, int y, TowerFactory.TowerType towerType, Player.Team owner) {
        if (towerType != null && getTile(x, y).buildTower(towerType, owner)) {
            towers.put(new Point(x, y), getTower(x, y));
        }
    }

    public void removeTower(int x, int y) {
        getTile(x, y).removeTower();
        towers.remove(new Point(x, y));
    }

    public void spawnUnit(UnitFactory.UnitType type, Player.Team team) {
        Unit unit = UnitFactory.getUnit(type, team, getSpawnTile(team));
        unit.generatePath(getPortalTile(team), this);
        units.add(unit);
    }

    public Unit getLastSpawnedUnit() {
        if (units.size() > 0)
            return units.get(units.size()-1);
        return null;
    }

    public void killLastSpawnedUnit() {
        if (units.isEmpty())
            return;

        units.remove(units.size()-1);
    }

    public Iterator<Unit> getUnitIterator() {
        return units.iterator();
    }

    public Pointf getSpawnTile(Player.Team owner) {
        Pointf spawn;
        switch (owner) {
            case BLUE:
                spawn = redSpawn.toPointf();
                break;
            case RED:
                spawn = blueSpawn.toPointf();
                break;
            default:
                throw new RuntimeException("Not a valid team");
        }
        spawn.add(0.5f, 0.5f); // Spawn at the center of the tile
        return spawn;
    }

    public Pointf getPortalTile(Player.Team owner) {
        switch (owner) {
            case BLUE:
                return redPortal.toPointf();
            case RED:
                return bluePortal.toPointf();
            default:
                throw new RuntimeException("Not a valid team");
        }
    }

}
