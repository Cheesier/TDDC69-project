package se.liu.ida.oscth887oskth878.tddc69.project.simulation;

import se.liu.ida.oscth887oskth878.tddc69.project.simulation.towers.*;

import java.util.EnumMap;

/**
 * A simple Factory for Towers
 *
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 29/09/2013
 */
public final class TowerFactory {
    private TowerFactory() {
    }

    public static enum TowerType {
        BASIC_TOWER, ADVANCED_TOWER, SPAWN, PORTAL
    }
    private static final EnumMap<TowerType, Tower> towers = new EnumMap<TowerType, Tower>(TowerType.class);

    public static Tower getTower(TowerType type, Player.Team owner) {
        switch (type) {
            case SPAWN:
                return new SpawnTower(Player.Team.NEUTRAL);
            case PORTAL:
                return new PortalTower(Player.Team.NEUTRAL);
            case BASIC_TOWER:
                return new BasicTower(owner);
            case ADVANCED_TOWER:
                return new AdvancedTower(owner);
            default:
                throw new RuntimeException("Cant get a nonexisting tower: " + type);
        }
    }
}
