package se.liu.ida.oscth887oskth878.tddc69.project.input;

import se.liu.ida.oscth887oskth878.tddc69.project.client.Client;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Player;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.UnitFactory;

import java.util.ArrayList;

/**
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 07/10/2013
 */
public class InputManager {
    private static final ArrayList<InputListener> listeners = new ArrayList<InputListener>();

    public static void addListener(InputListener listener) {
        listeners.add(listener);
    }

    public static void removeListener(InputListener listener) {
        listeners.remove(listener);
    }

    public static void placeTower(TowerPlacedEvent event) {
        for (InputListener listener : listeners) {
            listener.onTowerPlaced(event);
        }

        if (!event.isCanceled()) {
            Client.level.buildTower(event.getPosition().x, event.getPosition().y, event.getType(), event.getOwner());
            if (!Client.level.pathNotBlocked(event.getOwner()))
                Client.level.removeTower(event.getPosition().x, event.getPosition().y);
            else
                Client.level.updateAllPaths();
        }
    }

    public static void removeTower(TowerRemovedEvent event) {
        if (event.getType() == null)
            return;

        for (InputListener listener : listeners) {
            listener.onTowerRemoved(event);
        }

        if (!event.isCanceled()) {
            Client.level.removeTower(event.getPosition().x, event.getPosition().y);
            Client.level.updateAllPaths();
        }
    }

    public static void spawnUnit(UnitFactory.UnitType unitType, Player.Team owner) {
        Client.level.spawnUnit(unitType, owner);
        UnitSpawnedEvent event = new UnitSpawnedEvent(Client.level.getLastSpawnedUnit());

        for (InputListener listener : listeners) {
            listener.onUnitSpawned(event);
        }

        if (event.isCanceled()) {
            Client.level.killLastSpawnedUnit();
        }
    }

}
