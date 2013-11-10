package se.liu.ida.oscth887oskth878.tddc69.project.simulation;

import se.liu.ida.oscth887oskth878.tddc69.project.simulation.towers.Tower;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.units.Unit;

/**
 * Represents a tile on the level, also contains the tower placed on it and all the methods to modify them.
 *
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 15/09/2013
 */
public class Tile {
    // who can move over this tile
    protected static enum UnitMobility {
        NONE, ALL, GROUND_ONLY, AIR_ONLY
    }

    public static enum Type {
        GRASS, TOWER
    }

    private final UnitMobility unitMobility;
    private boolean buildable = false;
    private Tower tower;
    private final Type type;
    private final Player.Team owner;


    protected Tile(UnitMobility mobility, boolean buildable, Type type, Player.Team owner) {
        this.unitMobility = mobility;
        this.buildable = buildable;
        this.type = type;
        this.owner = owner;
    }


    public Player.Team getOwner() {
        return owner;
    }

    public Tower getTower() {
        return tower;
    }

    // Warning that it is inverted is a false positive
    // package local makes no sense here
    public boolean isBuildable() {
        return tower == null && buildable; // can only build on if no current tower is placed on tile
    }


    public boolean canPass(Unit unit) {
        if (unitMobility == UnitMobility.NONE) return false;
        if (tower != null && !tower.canPass(unit)) return false;

        switch (unit.getMoveType()) {
            case GROUND:
                return unitMobility == UnitMobility.ALL || unitMobility == UnitMobility.GROUND_ONLY;
            case AIR:
                return unitMobility == UnitMobility.ALL || unitMobility == UnitMobility.AIR_ONLY;
            default:
                System.err.println("Could not calculate the movability for: " + unit.getMoveType().toString());
                Thread.currentThread().getStackTrace();
                return false;
        }
    }

    public Type getType() {
        return type;
    }

    public boolean buildTower(TowerFactory.TowerType type, Player.Team owner) {
        if (!isBuildable())
            return false;

        tower = TowerFactory.getTower(type, owner);

        return true;
    }

    public void removeTower() {
        tower = null;
    }
}
