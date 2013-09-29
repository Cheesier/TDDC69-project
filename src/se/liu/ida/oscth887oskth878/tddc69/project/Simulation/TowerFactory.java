package se.liu.ida.oscth887oskth878.tddc69.project.Simulation;

import se.liu.ida.oscth887oskth878.tddc69.project.Simulation.Towers.BasicTower;

import java.util.EnumMap;

/**
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 29/09/2013
 */
public class TowerFactory {
    public static enum TowerType {
        BASIC_TOWER
    }
    public static final EnumMap<TowerType, Tower> towers = new EnumMap<TowerType, Tower>(TowerType.class);

    static {
        towers.put(TowerType.BASIC_TOWER, new BasicTower());
    }

    public static Tower getTower(TowerType type) {
        return towers.get(type);
    }
}