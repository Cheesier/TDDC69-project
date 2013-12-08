package se.liu.ida.oscth887oskth878.tddc69.project.client.input;

import se.liu.ida.oscth887oskth878.tddc69.project.client.Client;
import se.liu.ida.oscth887oskth878.tddc69.project.client.GUI;
import se.liu.ida.oscth887oskth878.tddc69.project.event.EventManager;
import se.liu.ida.oscth887oskth878.tddc69.project.util.Point;

/**
 * Handle all clicks performed on GUI elements.
 *
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 01/10/2013
 */
public class GUIClickHandler implements MouseListener {

    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public static void init() {
        new GUIClickHandler();
    }

    public GUIClickHandler() {
        MouseHandler.addTileListener(this);
    }

    @Override
    public void onLeftClick(MouseClickEvent event) {
        if (event.isButtonDown()) { // pressed down
            if (event.getLocation() == MouseClickEvent.Location.GUI) { // click was performed on GUI
                Point pos = MouseTranslator.getGui(event.getX(), event.getY());
                if (pos.x < GUI.getGuiTowerElements().length && GUI.getGuiTowerElements()[pos.x] != null) {
                    GUI.setSelectedTower(GUI.getGuiTowerElements()[pos.x]);
                    System.out.println("Selected " + GUI.getSelectedTower());
                }
                else if (pos.x >= GUI.getGuiTowerElements().length &&
                         pos.x < GUI.getGuiTowerElements().length + GUI.getGuiUnitElements().length &&
                         GUI.getGuiUnitElements()[pos.x - GUI.getGuiTowerElements().length] != null) {
                    EventManager.spawnUnit(GUI.getGuiUnitElements()[pos.x - GUI.getGuiTowerElements().length], Client.getPlayer().getTeam());
                }
            }
        }

    }

    @Override
    public void onRightClick(MouseClickEvent event) {
        if (event.getLocation() == MouseClickEvent.Location.GUI) { // click was performed on GUI
            if (event.isButtonDown() && GUI.getSelectedTower() != null) {
                System.out.println("Unselected " + GUI.getSelectedTower());
                GUI.setSelectedTower(null);
            }
        }
    }
}
