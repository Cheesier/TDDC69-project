package se.liu.ida.oscth887oskth878.tddc69.project.simulation;

import se.liu.ida.oscth887oskth878.tddc69.project.simulation.towers.Tower;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.units.Unit;
import se.liu.ida.oscth887oskth878.tddc69.project.util.Dimension;
import se.liu.ida.oscth887oskth878.tddc69.project.util.Point;
import se.liu.ida.oscth887oskth878.tddc69.project.util.Pointf;

import java.util.*;

/**
 * Saves all the Tiles and Units, contains all the methods to modify the gameboard.
 *
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 15/09/2013
 */
public class Level {
    private Tile[][] tileGrid;
    private ArrayList<Unit> units = new ArrayList<Unit>();
    private Map<Point, Tower> towers = new HashMap<Point, Tower>();

    private Dimension dimensions;

    private Point redSpawn;
    private Point blueSpawn;
    private Point redPortal;
    private Point bluePortal;

    public Level(int x, int y) {
        tileGrid = new Tile[x][y];
        dimensions = new Dimension(x, y);
    }

    public void tick() {
        Iterator<Unit> unitIterator = units.iterator();

        Iterator<Map.Entry<Point, Tower>> towerIterator = towers.entrySet().iterator();

        while (towerIterator.hasNext()) {
            Map.Entry<Point, Tower> entry = towerIterator.next();
            entry.getValue().tick(entry.getKey(), units.iterator());
        }

        while (unitIterator.hasNext()) {
            Unit unit = unitIterator.next();
            unit.tick();

            if (unit.getLifeState() == Unit.LifeState.PORTAL)
                unitAtPortal(unitIterator);
            else if (unit.getLifeState() == Unit.LifeState.KILLED)
                unitKilled(unitIterator);
        }
    }

    /**
     * Check to see whether or not the teams path has been blocked
     *
     * @param team the team that the path should be checked for
     * @return <code>true</code> if a path to the endpoint exists
     */
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

            if (!unit.generatePath(getPortalTile(unit.getOwner()), this)) {
                System.out.println("A unit had no path");
                unitAtPortal(unitIterator);
            }

        }
    }

    private void unitAtPortal(Iterator<Unit> unitIterator) {
        unitIterator.remove();
        System.out.println("A unit made it to the portal");
    }

    private void unitKilled(Iterator<Unit> unitIterator) {
        unitIterator.remove();
        System.out.println("A unit was killed");
    }

    // should not be shipped with release version
    // just for development
    public void generateBasicLevel() {
        for (int x = 0; x < dimensions.x; x++) {
            for (int y = 0; y < dimensions.y; y++) {
                if (x > dimensions.x / 2)
                    this.setTile(x, y, new Tile(Tile.UnitMobility.ALL, true, Tile.Type.GRASS, Player.Team.BLUE));
                else if (x < dimensions.x / 2 - 1)
                    this.setTile(x, y, new Tile(Tile.UnitMobility.ALL, true, Tile.Type.GRASS, Player.Team.RED));
                else
                    this.setTile(x, y, new Tile(Tile.UnitMobility.ALL, true, Tile.Type.GRASS, Player.Team.NEUTRAL));
            }
        }

        redSpawn = new Point(dimensions.x/2-1, dimensions.y/2);
        blueSpawn = new Point(dimensions.x/2, dimensions.y/2);
        redPortal = new Point(0, dimensions.y/2);
        bluePortal = new Point(dimensions.x - 1, dimensions.y/2);

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

    public Tower getTower(Point point) {
        return getTower(point.x, point.y);
    }

    public Tower getTower(int x, int y) {
        return getTile(x, y).getTower();
    }

    public boolean canPass(Point point, Unit unit) {
        return canPass(point.x, point.y, unit);
    }

    public boolean canPass(int x, int y, Unit unit) {
        return getTile(x, y).canPass(unit);
    }

    public void setTile(Point point, Tile tileType) {
        setTile(point.x, point.y, tileType);
    }

    public void setTile(int x, int y, Tile tileType) {
        tileGrid[x][y] = tileType;
    }

    public Dimension getDimensions() {
        return dimensions;
    }

    public void buildTower(Point point, TowerFactory.TowerType towerType, Player.Team owner) {
        buildTower(point.x, point.y, towerType, owner);
    }

    public void buildTower(int x, int y, TowerFactory.TowerType towerType, Player.Team owner) {
        if (towerType != null && getTile(x, y).buildTower(towerType, owner)) {
            towers.put(new Point(x, y), getTower(x, y));
        }
    }

    public void removeTower(Point point) {
        removeTower(point.x, point.y);
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
        if (!units.isEmpty())
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
        spawn.add(Tile.HALF_TILE, Tile.HALF_TILE); // Spawn at the center of the tile
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
