package se.liu.ida.oscth887oskth878.tddc69.project.client.input;

import se.liu.ida.oscth887oskth878.tddc69.project.client.Client;
import se.liu.ida.oscth887oskth878.tddc69.project.client.GUI;
import se.liu.ida.oscth887oskth878.tddc69.project.event.EventManager;
import se.liu.ida.oscth887oskth878.tddc69.project.util.Point;

/**
 * Handles all the clicks that was performed on a <code>Tile</code>.
 *
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 01/10/2013
 */
public class TileClickHandler implements MouseListener {

    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public static void init() {
        new TileClickHandler();
    }

    public TileClickHandler() {
        MouseHandler.addTileListener(this);
    }

    @Override
    public void onLeftClick(MouseClickEvent event) {
        if (!event.isButtonDown()) { // released mouse button
            if (event.getLocation() == MouseClickEvent.Location.TILE) { // click was performed on a TILE
                Point point = MouseTranslator.getTile(event.getX(), event.getY());
                EventManager.placeTower(Client.getPlayer(), GUI.getSelectedTower(), point);
            }
        }
    }

    @Override
    public void onRightClick(MouseClickEvent event) {
        if (!event.isButtonDown()) { // released mouse button
            if (event.getLocation() == MouseClickEvent.Location.TILE) { // click was performed on a TILE
                Point point = MouseTranslator.getTile(event.getX(), event.getY());
                EventManager.removeTower(Client.getPlayer(), point);
            }
        }
    }
}
