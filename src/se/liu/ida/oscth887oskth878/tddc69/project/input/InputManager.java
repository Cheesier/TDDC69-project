package se.liu.ida.oscth887oskth878.tddc69.project.input;

import se.liu.ida.oscth887oskth878.tddc69.project.client.Game;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Player;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.TowerFactory;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.UnitFactory;
import se.liu.ida.oscth887oskth878.tddc69.project.util.Point;

import java.util.ArrayList;

/**
 * All clients way of modifying the game.
 *
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

    public static void placeTower(Player player, TowerFactory.TowerType type, Point position) {
        TowerPlacedEvent event = new TowerPlacedEvent(player, type, position);
        for (InputListener listener : listeners) {
            listener.onTowerPlaced(event);
        }

        if (!event.isCanceled()) {
            Game.level.buildTower(event.getPosition(), event.getType(), event.getPlayer().getTeam());
            if (!Game.level.pathNotBlocked(event.getPlayer().getTeam()))
                Game.level.removeTower(event.getPosition());
            else
                Game.level.updateAllPaths();
        }
    }

    public static void removeTower(Player player, Point position) {
        if (Game.level.getTower(position) == null)
            return;

        TowerRemovedEvent event = new TowerRemovedEvent(player, Game.level.getTower(position).getTowerType(), position);

        if (event.getType() == null)
            return;

        for (InputListener listener : listeners) {
            listener.onTowerRemoved(event);
        }

        if (!event.isCanceled()) {
            Game.level.removeTower(event.getPosition().x, event.getPosition().y);
            Game.level.updateAllPaths();
        }
    }

    public static void spawnUnit(UnitFactory.UnitType unitType, Player.Team owner) {
        Game.level.spawnUnit(unitType, owner);
        UnitSpawnedEvent event = new UnitSpawnedEvent(Game.level.getLastSpawnedUnit());

        for (InputListener listener : listeners) {
            listener.onUnitSpawned(event);
        }

        if (event.isCanceled()) {
            Game.level.killLastSpawnedUnit();
        }
    }

}
