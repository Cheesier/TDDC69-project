package se.liu.ida.oscth887oskth878.tddc69.project.Simulation.Towers;

import se.liu.ida.oscth887oskth878.tddc69.project.Simulation.Tower;

/**
 * @version 1.0
 * @author: Oskar Therén
 * @author: Oscar Thunberg
 * @since: 24/09/2013
 */
public class BasicTower extends Tower{
    public static final UnitMobility unitMobility = UnitMobility.AIR_ONLY;
    public static final DamageType damageType = DamageType.PHYSICAL;
    public static final int damage = 5;
    public static final int range = 2;

    protected BasicTower() {
        super(unitMobility, damageType, damage, range);
    }
}
