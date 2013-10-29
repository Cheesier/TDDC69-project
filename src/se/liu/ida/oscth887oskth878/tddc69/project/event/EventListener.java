package se.liu.ida.oscth887oskth878.tddc69.project.event;

/**
 * Interface to implement for anyone that is interested in listening to changes made in the game.
 *
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 04/10/2013
 */
public interface EventListener {
    public void onTowerPlaced(TowerPlacedEvent event);
    public void onTowerRemoved(TowerRemovedEvent event);
    public void onUnitSpawned(UnitSpawnedEvent event);
}
