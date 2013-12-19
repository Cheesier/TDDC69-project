package se.liu.ida.oscth887oskth878.tddc69.project.network.packet.protocol;

import com.esotericsoftware.kryonet.Connection;
import org.lwjgl.opengl.Display;
import se.liu.ida.oscth887oskth878.tddc69.project.client.Client;
import se.liu.ida.oscth887oskth878.tddc69.project.network.NetworkConnection;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Player;

/**
 * Packet that is sent from the server to the client right after an InitPacket has been received and everything is okay,
 * is more or less just used for giving the client his/hers <code>Player</code> object.
 *
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 09/10/2013
 */
public class ConnectionEstablishedPacket implements ProtocolPacket {
    private Player player = null;

    public ConnectionEstablishedPacket() {
    }

    public ConnectionEstablishedPacket(Player player) {
        this.player = player;
    }

    @Override
    public void onClientReceive(Connection connection) {
        System.out.println("I am: " + player.getTeam());
        Display.setTitle(this.player.getName() + " playing on team " + this.player.getTeam());
        Client.setPlayer(this.player);
    }

    @Override
    public void onServerReceive(NetworkConnection connection) {
        // Only read from client side.
    }
}
