package se.liu.ida.oscth887oskth878.tddc69.project.Simulation;

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

    protected Tower(UnitMobility unitMobility, DamageType damageType, int damage, int range) {
        super(unitMobility, false, Type.TOWER);
        this.damageType = damageType;
        this.damage = damage;
        this.range = range;
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
