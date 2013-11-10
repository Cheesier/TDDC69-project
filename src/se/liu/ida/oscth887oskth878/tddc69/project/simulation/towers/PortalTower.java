package se.liu.ida.oscth887oskth878.tddc69.project.simulation.towers;

import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Player;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.TowerFactory;

/**
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 07/10/2013
 */
@SuppressWarnings("WeakerAccess")
public class PortalTower extends Tower {
    public static final TowerFactory.TowerType TOWER_TYPE = TowerFactory.TowerType.PORTAL;
    public static final UnitMobility UNIT_MOBILITY = UnitMobility.ALL;
    public static final DamageType DAMAGE_TYPE = DamageType.PHYSICAL;
    public static final int DAMAGE = 0;
    public static final float RANGE = -1;
    public static final int COOLDOWN = 0;
    public static final Player.Team OWNER = Player.Team.NEUTRAL;

    public PortalTower() {
        super(TOWER_TYPE, UNIT_MOBILITY, DAMAGE_TYPE, DAMAGE, RANGE, COOLDOWN, OWNER);
    }
}
