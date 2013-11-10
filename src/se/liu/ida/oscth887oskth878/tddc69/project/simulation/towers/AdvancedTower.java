package se.liu.ida.oscth887oskth878.tddc69.project.simulation.towers;

import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Player;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.TowerFactory;

/**
 * @author Oskar Therén
 * @author Oscar Thunberg
 * @version 1.0
 * @since 15/10/2013
 */
@SuppressWarnings("WeakerAccess")
public class AdvancedTower extends Tower {
    public static final TowerFactory.TowerType TOWER_TYPE = TowerFactory.TowerType.ADVANCED_TOWER;
    public static final UnitMobility UNIT_MOBILITY = UnitMobility.AIR_ONLY;
    public static final Tower.DamageType DAMAGE_TYPE = Tower.DamageType.PHYSICAL;
    public static final int DAMAGE = 15;
    public static final float RANGE = 3;
    public static final int COOLDOWN = 15;

    public AdvancedTower(Player.Team owner) {
        super(TOWER_TYPE, UNIT_MOBILITY, DAMAGE_TYPE, DAMAGE, RANGE, COOLDOWN, owner);
    }
}
