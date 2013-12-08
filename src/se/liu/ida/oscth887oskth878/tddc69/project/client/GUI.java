package se.liu.ida.oscth887oskth878.tddc69.project.client;

import se.liu.ida.oscth887oskth878.tddc69.project.client.input.GUIClickHandler;
import se.liu.ida.oscth887oskth878.tddc69.project.client.input.TileClickHandler;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.TowerFactory;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.UnitFactory;

/**
 * Holds the way the GUI should look.
 *
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 30/09/2013
 */
public final class GUI {
    private GUI() {
    }

    public enum GUIElements {
        BACKGROUND
    }

    static {
        GUIClickHandler.init();
        TileClickHandler.init();
    }

    public static final TowerFactory.TowerType[] GUI_TOWER_ELEMENTS = new TowerFactory.TowerType[] {
            TowerFactory.TowerType.BASIC_TOWER,
            TowerFactory.TowerType.ADVANCED_TOWER,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null                                    //Add spaces to separate towers and units
    };

    public static final UnitFactory.UnitType[] GUI_UNIT_ELEMENTS = new UnitFactory.UnitType[] {
            UnitFactory.UnitType.BASIC_UNIT,
            UnitFactory.UnitType.GOOMBA_UNIT,
            UnitFactory.UnitType.ADVANCED_UNIT,
            UnitFactory.UnitType.BASIC_FLYING

    };

    private static TowerFactory.TowerType selectedTower = null;

    public static TowerFactory.TowerType getSelectedTower() {
        return selectedTower;
    }

    public static void setSelectedTower(TowerFactory.TowerType type) {
        selectedTower = type;
    }
}
