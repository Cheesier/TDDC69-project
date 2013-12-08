package se.liu.ida.oscth887oskth878.tddc69.project.simulation.towers;

import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Player;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.TowerFactory;

/**
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 07/10/2013
 */
public class PortalTower extends Tower {
    private static final TowerFactory.TowerType TOWER_TYPE = TowerFactory.TowerType.PORTAL;
    private static final UnitMobility UNIT_MOBILITY = UnitMobility.ALL;
    private static final int DAMAGE = 0;
    private static final float RANGE = -1;
    private static final int COOLDOWN = 0;

    public PortalTower(Player.Team owner) {
        super(TOWER_TYPE, UNIT_MOBILITY, DAMAGE, RANGE, COOLDOWN, owner);
    }
}
