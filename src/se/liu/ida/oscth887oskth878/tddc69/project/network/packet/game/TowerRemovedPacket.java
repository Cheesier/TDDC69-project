package se.liu.ida.oscth887oskth878.tddc69.project.network.packet.game;

import com.esotericsoftware.kryonet.Connection;
import se.liu.ida.oscth887oskth878.tddc69.project.event.EventManager;
import se.liu.ida.oscth887oskth878.tddc69.project.network.NetworkConnection;
import se.liu.ida.oscth887oskth878.tddc69.project.server.Server;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Player;
import se.liu.ida.oscth887oskth878.tddc69.project.util.Point;

/**
 * Notify other clients that a <code>Tower</code> should be removed.
 *
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 09/10/2013
 */
public class TowerRemovedPacket extends TowerPacket {

    public TowerRemovedPacket() {
    }

    public TowerRemovedPacket(Player player, Point position) {
        super(player, position);
    }

    @Override
    public void onClientReceive(Connection connection) {
        EventManager.removeTower(this.getPlayer(), this.getPosition());
    }

    @Override
    public void onServerReceive(NetworkConnection connection) {
        Server.getServer().sendToAllExcept(connection.getID(), this);
    }
}
