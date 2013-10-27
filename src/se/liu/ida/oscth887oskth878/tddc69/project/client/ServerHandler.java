package se.liu.ida.oscth887oskth878.tddc69.project.client;

import se.liu.ida.oscth887oskth878.tddc69.project.input.EventListener;
import se.liu.ida.oscth887oskth878.tddc69.project.input.TowerPlacedEvent;
import se.liu.ida.oscth887oskth878.tddc69.project.input.TowerRemovedEvent;
import se.liu.ida.oscth887oskth878.tddc69.project.input.UnitSpawnedEvent;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.game.TowerPlacedPacket;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.game.TowerRemovedPacket;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.game.UnitSpawnedPacket;

/**
 * Send every action the client does to the server.
 *
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 09/10/2013
 */
public class ServerHandler implements EventListener {
    private static final ServerHandler instance = new ServerHandler(); // use this class as a singleton

    private ServerHandler() {}

    @Override
    public void onTowerPlaced(TowerPlacedEvent event) {
        if (event.isCanceled())
            return;

        if (event.getPlayer().equals(Client.player)) {
            Client.server.send(new TowerPlacedPacket(event.getPlayer(), event.getPosition(), event.getType()));
        }
    }

    @Override
    public void onTowerRemoved(TowerRemovedEvent event) {
        if (event.isCanceled())
            return;

        if (event.getPlayer().equals(Client.player)) {
            Client.server.send(new TowerRemovedPacket(event.getPlayer(), event.getPosition()));
        }
    }

    @Override
    public void onUnitSpawned(UnitSpawnedEvent event) {
        if (event.isCanceled())
            return;

        if (event.getUnit().getOwner() == Client.player.getTeam()) {
            Client.server.send(new UnitSpawnedPacket(event.getUnit().getUnitType(), event.getUnit().getOwner()));
        }
    }

    public static ServerHandler getInstance() {
        return instance;
    }
}
