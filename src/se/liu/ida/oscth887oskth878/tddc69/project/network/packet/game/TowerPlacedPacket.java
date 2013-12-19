package se.liu.ida.oscth887oskth878.tddc69.project.network.packet.game;

import com.esotericsoftware.kryonet.Connection;
import se.liu.ida.oscth887oskth878.tddc69.project.event.EventManager;
import se.liu.ida.oscth887oskth878.tddc69.project.network.NetworkConnection;
import se.liu.ida.oscth887oskth878.tddc69.project.server.Server;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Player;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.TowerFactory;
import se.liu.ida.oscth887oskth878.tddc69.project.util.Point;

/**
 * Notify other clients that a <code>Tower</code> should be placed.
 *
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 09/10/2013
 */
public class TowerPlacedPacket extends TowerPacket {
    private TowerFactory.TowerType towerType = null;

    public TowerPlacedPacket() {
    }

    public TowerPlacedPacket(Player player, Point position, TowerFactory.TowerType towerType) {
        super(player, position);
        this.towerType = towerType;
    }

    @Override
    public void onClientReceive(Connection connection) {
        EventManager.placeTower(this.getPlayer(), this.towerType, this.getPosition());
    }

    @Override
    public void onServerReceive(NetworkConnection connection) {
        Server.getServer().sendToAllExcept(connection.getID(), this);
    }
}
