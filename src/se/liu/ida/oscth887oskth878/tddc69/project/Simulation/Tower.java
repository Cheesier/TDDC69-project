package se.liu.ida.oscth887oskth878.tddc69.project.Simulation;

/**
 * Created with IntelliJ IDEA.
 * User: Oscar
 * Date: 2013-09-15
 * Time: 20:27
 */
public abstract class Tower extends Tile {
    public enum DamageType {
        PHYSICAL
    }

    protected Tower(MonsterMobility monsterMobility) {
        super(monsterMobility, false);
    }
}
