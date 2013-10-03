package se.liu.ida.oscth887oskth878.tddc69.project.simulation;

/**
 * Created with IntelliJ IDEA.
 * User: Oscar
 * Date: 2013-09-15
 * Time: 20:27
 */
public abstract class Tower extends Tile {
    public static enum DamageType {
        PHYSICAL
    }
    private int damage;
    private DamageType damageType;
    private int range;
    private TowerFactory.TowerType towerType;

    protected Tower(TowerFactory.TowerType type, UnitMobility unitMobility, DamageType damageType, int damage, int range) {
        super(unitMobility, false, Type.TOWER);
        this.towerType = type;
        this.damageType = damageType;
        this.damage = damage;
        this.range = range;
    }

    public TowerFactory.TowerType getTowerType() {
        return this.towerType;
    }

    public int getRange() {
        return range;
    }

    public DamageType getDamageType() {
        return damageType;
    }

    public int getDamage() {
        return damage;
    }
}
