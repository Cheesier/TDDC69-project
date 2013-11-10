package se.liu.ida.oscth887oskth878.tddc69.project.simulation.towers;

import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Player;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.TowerFactory;

/**
 * @author Oskar Therén
 * @author Oscar Thunberg
 * @version 1.0
 * @since 24/09/2013
 */
@SuppressWarnings("WeakerAccess")
public class BasicTower extends Tower{
    public static final TowerFactory.TowerType TOWER_TYPE = TowerFactory.TowerType.BASIC_TOWER;
    public static final UnitMobility UNIT_MOBILITY = UnitMobility.AIR_ONLY;
    public static final DamageType DAMAGE_TYPE = DamageType.PHYSICAL;
    public static final int DAMAGE = 5;
    public static final float RANGE = 2;
    public static final int COOLDOWN = 20;

    public BasicTower(Player.Team owner) {
        super(TOWER_TYPE, UNIT_MOBILITY, DAMAGE_TYPE, DAMAGE, RANGE, COOLDOWN, owner);
    }
}
