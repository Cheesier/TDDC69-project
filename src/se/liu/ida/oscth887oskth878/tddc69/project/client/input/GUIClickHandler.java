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

    public static void init() {} // just to trigger the initialization of "instance"

    public static GUIClickHandler instance = new GUIClickHandler(); // need this instance to listen to mouse events

    private GUIClickHandler() {
        MouseHandler.addTileListener(this);
    }

    @Override
    public void onLeftClick(MouseClickEvent event) {
        if (event.getState()) { // pressed down
            if (event.getLocation() == MouseClickEvent.Location.GUI) { // click was performed on GUI
                Point pos = MouseTranslator.getGui(event.getX(), event.getY());
                if (pos.x < GUI.guiTowerElements.length && GUI.guiTowerElements[pos.x] != null) {
                    GUI.selectedTower = GUI.guiTowerElements[pos.x];
                    System.out.println("Selected " + GUI.selectedTower);
                }
                else if (pos.x >= GUI.guiTowerElements.length &&
                         pos.x < GUI.guiTowerElements.length + GUI.guiUnitElements.length &&
                         GUI.guiUnitElements[pos.x - GUI.guiTowerElements.length] != null) {
                    EventManager.spawnUnit(GUI.guiUnitElements[pos.x - GUI.guiTowerElements.length], Client.player.getTeam());
                }
            }
        }

    }

    @Override
    public void onRightClick(MouseClickEvent event) {
        if (event.getLocation() == MouseClickEvent.Location.GUI) { // click was performed on GUI
            if (event.getState() && GUI.selectedTower != null) {
                System.out.println("Unselected " + GUI.selectedTower);
                GUI.selectedTower = null;
            }
        }
    }
}
