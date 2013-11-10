package se.liu.ida.oscth887oskth878.tddc69.project.event;

import se.liu.ida.oscth887oskth878.tddc69.project.client.Game;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Player;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.TowerFactory;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.UnitFactory;
import se.liu.ida.oscth887oskth878.tddc69.project.util.Point;

import java.util.ArrayList;
import java.util.EnumMap;

/**
 * All clients way of modifying the game.
 *
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 07/10/2013
 */
public class EventManager {
    public static enum EventPriority {
        LOWEST, LOW, NORMAL, HIGH, HIGHEST, MONITOR
    }

    private static final EnumMap<EventPriority, ArrayList<EventListener>> priorityListeners;

    static {
        priorityListeners = new EnumMap<EventPriority, ArrayList<EventListener>>(EventPriority.class);
        for (EventPriority o : EventPriority.values()) {
            priorityListeners.put(o, new ArrayList<EventListener>());
        }
    }

    //private static final ArrayList<EventListener> listeners = new ArrayList<EventListener>();

    public static void addListener(EventListener listener, EventPriority eventPriority) {
        ArrayList<EventListener> listeners = priorityListeners.get(eventPriority);
        if (!listeners.contains(listener))
            listeners.add(listener);
    }

    public static void placeTower(Player player, TowerFactory.TowerType type, Point position) {
        TowerPlacedEvent event = new TowerPlacedEvent(player, type, position);

        notifyListeners(event);

        if (!event.isCanceled()) {
            Game.level.buildTower(event.getPosition(), event.getType(), event.getPlayer().getTeam());
            if (Game.level.isPathBlocked(event.getPlayer().getTeam()))
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

        notifyListeners(event);

        if (!event.isCanceled()) {
            Game.level.removeTower(event.getPosition().x, event.getPosition().y);
            Game.level.updateAllPaths();
        }
    }

    public static void spawnUnit(UnitFactory.UnitType unitType, Player.Team owner) {
        Game.level.spawnUnit(unitType, owner);
        UnitSpawnedEvent event = new UnitSpawnedEvent(Game.level.getLastSpawnedUnit());

        notifyListeners(event);

        if (event.isCanceled()) {
            Game.level.killLastSpawnedUnit();
        }
    }

    private static void notifyListeners(Event event) {
        for (EventPriority priority : EventPriority.values()) {
            ArrayList<EventListener> listeners = priorityListeners.get(priority);
            for (EventListener listener : listeners) {

                if (event instanceof TowerPlacedEvent)
                    listener.onTowerPlaced((TowerPlacedEvent)event);
                else if (event instanceof TowerRemovedEvent)
                    listener.onTowerRemoved((TowerRemovedEvent) event);
                else if (event instanceof UnitSpawnedEvent)
                    listener.onUnitSpawned((UnitSpawnedEvent) event);

            }
        }

    }

}
