package se.liu.ida.oscth887oskth878.tddc69.project.client;

import se.liu.ida.oscth887oskth878.tddc69.project.client.input.GUIClickHandler;
import se.liu.ida.oscth887oskth878.tddc69.project.client.input.TileClickHandler;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.TowerFactory;

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

    static {
        GUIClickHandler.init();
        TileClickHandler.init();
    }

    public static final TowerFactory.TowerType[] guiTowerElements = new TowerFactory.TowerType[] {
            TowerFactory.TowerType.BASIC_TOWER,
            null,
            TowerFactory.TowerType.BASIC_TOWER
    };

    public static final GUI instance = new GUI();

    public static TowerFactory.TowerType selectedTower = null;
}
