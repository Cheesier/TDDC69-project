package se.liu.ida.oscth887oskth878.tddc69.project.client;

import se.liu.ida.oscth887oskth878.tddc69.project.event.EventListener;
import se.liu.ida.oscth887oskth878.tddc69.project.event.TowerPlacedEvent;
import se.liu.ida.oscth887oskth878.tddc69.project.event.TowerRemovedEvent;
import se.liu.ida.oscth887oskth878.tddc69.project.event.UnitSpawnedEvent;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.towers.Tower;

/**
 * Main handler for client interaction, prevent placement of towers on enemy territory.
 *
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 07/10/2013
 */
public class EventHandler implements EventListener {
    private static final EventHandler INSTANCE = new EventHandler(); // use this class as a singleton

    private EventHandler() {}

    @Override
    public void onTowerPlaced(TowerPlacedEvent event) {
        if (event.isCanceled())
            return;

        if (Game.LEVEL.getTileOwner(event.getPosition().x, event.getPosition().y) != event.getPlayer().getTeam()) {
                event.setCanceled(true);
        }
    }

    @Override
    public void onTowerRemoved(TowerRemovedEvent event) {
        if (event.isCanceled())
            return;

        Tower tower = Game.LEVEL.getTower(event.getPosition());
        if (tower == null)
            return;

        if (tower.getOwner() != event.getPlayer().getTeam()) {
            event.setCanceled(true);
        }
    }

    @Override
    public void onUnitSpawned(UnitSpawnedEvent event) {

    }

    public static EventHandler getInstance() {
        return INSTANCE;
    }
}
