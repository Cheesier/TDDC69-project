package se.liu.ida.oscth887oskth878.tddc69.project.simulation;

/**
 * Created with IntelliJ IDEA.
 * User: Oscar
 * Date: 2013-09-15
 * Time: 20:26
 */
public class Tile {
    // who can move over this tile
    protected static enum UnitMobility {
        NONE, ALL, GROUND_ONLY, AIR_ONLY
    }

    public static enum Type {
        GRASS, SPECIAL, TOWER
    }

    protected UnitMobility unitMobility;
    private boolean buildable = false;
    private Tower tower;
    private Type type;
    private Player.Team owner = Player.Team.NEUTRAL;


    protected Tile(UnitMobility mobility, boolean buildable, Type type) {
        this.unitMobility = mobility;
        this.buildable = buildable;
        this.type = type;
    }

    public void setOwner(Player.Team owner) {
        this.owner = owner;
    }

    public Tower getTower() {
        return tower;
    }

    public boolean isBuildable() {
        return (tower == null && buildable); // can only build on if no current tower is placed on tile
    }

    protected void setBuildable(boolean buildable) {
        this.buildable = buildable;
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

    public boolean buildTower(TowerFactory.TowerType type) {
        if (!isBuildable())
            return false;

        tower = TowerFactory.getTower(type);
        return true;
    }

    public void removeTower() {
        tower = null;
    }
}
