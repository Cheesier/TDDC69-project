package se.liu.ida.oscth887oskth878.tddc69.project.client;

import se.liu.ida.oscth887oskth878.tddc69.project.client.input.GUIClickHandler;
import se.liu.ida.oscth887oskth878.tddc69.project.client.input.TileClickHandler;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.TowerFactory;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.UnitFactory;

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
            null
    };

    public static final UnitFactory.UnitType[] guiUnitElements = new UnitFactory.UnitType[] {
            UnitFactory.UnitType.BASIC_UNIT,
            UnitFactory.UnitType.GOOMBA_UNIT,
            UnitFactory.UnitType.ADVANCED_UNIT,
            UnitFactory.UnitType.BASIC_FLYING

    };

    public static final GUI instance = new GUI();

    public static TowerFactory.TowerType selectedTower = null;
}
