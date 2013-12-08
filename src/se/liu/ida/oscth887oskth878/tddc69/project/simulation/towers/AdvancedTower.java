package se.liu.ida.oscth887oskth878.tddc69.project.simulation.towers;

import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Player;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.TowerFactory;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.towers.Tower.DamageType;

/**
 * @author Oskar Therén
 * @author Oscar Thunberg
 * @version 1.0
 * @since 15/10/2013
 */
public class AdvancedTower extends Tower {
    private static final TowerFactory.TowerType TOWER_TYPE = TowerFactory.TowerType.ADVANCED_TOWER;
    private static final UnitMobility UNIT_MOBILITY = UnitMobility.AIR_ONLY;
    private static final DamageType DAMAGE_TYPE = DamageType.PHYSICAL;
    private static final int DAMAGE = 15;
    private static final float RANGE = 3;
    private static final int COOLDOWN = 15;

    public AdvancedTower(Player.Team owner) {
        super(TOWER_TYPE, UNIT_MOBILITY, DAMAGE_TYPE, DAMAGE, RANGE, COOLDOWN, owner);
    }
}
