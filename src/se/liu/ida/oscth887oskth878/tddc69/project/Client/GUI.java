package se.liu.ida.oscth887oskth878.tddc69.project.Client;

import se.liu.ida.oscth887oskth878.tddc69.project.Simulation.Placeable;
import se.liu.ida.oscth887oskth878.tddc69.project.Simulation.TowerFactory;

import java.util.ArrayList;

/**
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 30/09/2013
 */
public class GUI {
    public enum GUIElements {
        BACKGROUND
    }
    public static final ArrayList<TowerFactory.TowerType> towers = new ArrayList<TowerFactory.TowerType>();

    static {
        towers.add(TowerFactory.TowerType.BASIC_TOWER);
    }
}
