package se.liu.ida.oscth887oskth878.tddc69.project.simulation;

import se.liu.ida.oscth887oskth878.tddc69.project.simulation.towers.BasicTower;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.towers.PortalTower;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.towers.SpawnTower;

import java.util.EnumMap;

/**
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 29/09/2013
 */
public class TowerFactory {
    public static enum TowerType {
        BASIC_TOWER, SPAWN, PORTAL
    }
    public static final EnumMap<TowerType, Tower> towers = new EnumMap<TowerType, Tower>(TowerType.class);

    static {
        towers.put(TowerType.BASIC_TOWER, new BasicTower(Player.Team.NEUTRAL)); // team is added for debug!

        towers.put(TowerType.SPAWN, new SpawnTower(Player.Team.NEUTRAL));
        towers.put(TowerType.PORTAL, new PortalTower(Player.Team.NEUTRAL));
    }

    public static Tower getTower(TowerType type) {
        return towers.get(type);
    }
}
