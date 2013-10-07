package se.liu.ida.oscth887oskth878.tddc69.project.client;

import se.liu.ida.oscth887oskth878.tddc69.project.input.InputListener;
import se.liu.ida.oscth887oskth878.tddc69.project.input.TowerPlacedEvent;
import se.liu.ida.oscth887oskth878.tddc69.project.input.UnitSpawnedEvent;

/**
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 07/10/2013
 */
public class EventHandler implements InputListener {
    @Override
    public void onTowerPlaced(TowerPlacedEvent event) {
        if (Client.level.getTileOwner(event.getPosition().x, event.getPosition().y) != Client.player.team) {
                event.setCanceled(true);
        }
    }

    @Override
    public void onUnitSpawned(UnitSpawnedEvent event) {

    }
}
