package se.liu.ida.oscth887oskth878.tddc69.project.client.input;

import se.liu.ida.oscth887oskth878.tddc69.project.client.Client;
import se.liu.ida.oscth887oskth878.tddc69.project.client.GUI;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Player;
import se.liu.ida.oscth887oskth878.tddc69.project.util.Point;

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
                Client.level.buildTower(point.x, point.y, GUI.selectedTower, Player.Team.BLUE);
            }
        }
    }

    @Override
    public void onRightClick(MouseClickEvent event) {
        if (!event.getState()) { // released mouse button
            if (event.getLocation() == MouseClickEvent.Location.TILE) { // click was performed on a TILE
                Point point = MouseTranslator.getTile(event.getX(), event.getY());
                Client.level.removeTower(point.x, point.y);
            }
        }
    }
}
