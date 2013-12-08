package se.liu.ida.oscth887oskth878.tddc69.project.event;

import se.liu.ida.oscth887oskth878.tddc69.project.client.Game;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Player;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.TowerFactory;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.UnitFactory;
import se.liu.ida.oscth887oskth878.tddc69.project.util.Point;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;

/**
 * All clients way of modifying the game.
 *
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 07/10/2013
 */
public final class EventManager {
    private EventManager() {
    }

    public enum EventPriority {
        LOWEST, LOW, NORMAL, HIGH, HIGHEST, MONITOR
    }

    private final static EnumMap<EventPriority, ArrayList<EventListener>> PRIORITY_LISTENERS;

    static {
        PRIORITY_LISTENERS = new EnumMap<EventPriority, ArrayList<EventListener>>(EventPriority.class);
        for (EventPriority o : EventPriority.values()) {
            PRIORITY_LISTENERS.put(o, new ArrayList<EventListener>());
        }
    }

    //private static final ArrayList<EventListener> listeners = new ArrayList<EventListener>();

    public static void addListener(EventListener listener, EventPriority eventPriority) {
        Collection<EventListener> listeners = PRIORITY_LISTENERS.get(eventPriority);
        if (!listeners.contains(listener))
            listeners.add(listener);
    }

    public static void placeTower(Player player, TowerFactory.TowerType type, Point position) {
        TowerPlacedEvent event = new TowerPlacedEvent(player, type, position);

        notifyListeners(event);

        if (!event.isCanceled()) {
            Game.LEVEL.buildTower(event.getPosition(), event.getType(), event.getPlayer().getTeam());
            if (!Game.LEVEL.isPathNotBlocked(event.getPlayer().getTeam()))
                Game.LEVEL.removeTower(event.getPosition());
            else
                Game.LEVEL.updateAllPaths();
        }
    }

    public static void removeTower(Player player, Point position) {
        if (Game.LEVEL.getTower(position) == null)
            return;

        TowerRemovedEvent event = new TowerRemovedEvent(player, Game.LEVEL.getTower(position).getTowerType(), position);

        if (event.getType() == null)
            return;

        notifyListeners(event);

        if (!event.isCanceled()) {
            Game.LEVEL.removeTower(event.getPosition().x, event.getPosition().y);
            Game.LEVEL.updateAllPaths();
        }
    }

    public static void spawnUnit(UnitFactory.UnitType unitType, Player.Team owner) {
        Game.LEVEL.spawnUnit(unitType, owner);
        UnitSpawnedEvent event = new UnitSpawnedEvent(Game.LEVEL.getLastSpawnedUnit());

        notifyListeners(event);

        if (event.isCanceled()) {
            Game.LEVEL.killLastSpawnedUnit();
        }
    }

    private static void notifyListeners(Event event) {
        for (EventPriority priority : EventPriority.values()) {
            Iterable<EventListener> listeners = PRIORITY_LISTENERS.get(priority);
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
