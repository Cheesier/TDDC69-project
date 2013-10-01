package se.liu.ida.oscth887oskth878.tddc69.project.Client.input;

import se.liu.ida.oscth887oskth878.tddc69.project.Client.Client;
import se.liu.ida.oscth887oskth878.tddc69.project.Client.GUI;
import se.liu.ida.oscth887oskth878.tddc69.project.Util.Point;

/**
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 01/10/2013
 */
public class TileClickHandler implements MouseListener {

    public static void init() {} // just to trigger the initialization of "instance"

    public static TileClickHandler instance = new TileClickHandler();

    public TileClickHandler() {
        MouseHandler.addTileListener(this);
    }

    @Override
    public void onLeftClick(MouseClickEvent event) {
        if (!event.getState()) { // released mouse button
            if (event.getLocation() == MouseClickEvent.Location.TILE) { // click was performed on a TILE
                Point point = MouseTranslator.getTile(event.getX(), event.getY());
                Client.level.getTile(point).buildTower(GUI.selectedTower);
            }
        }
    }

    @Override
    public void onRightClick(MouseClickEvent event) {
        if (!event.getState()) { // released mouse button
            if (event.getLocation() == MouseClickEvent.Location.TILE) { // click was performed on a TILE
                Point point = MouseTranslator.getTile(event.getX(), event.getY());
                Client.level.getTile(point).removeTower();
            }
        }
    }
}