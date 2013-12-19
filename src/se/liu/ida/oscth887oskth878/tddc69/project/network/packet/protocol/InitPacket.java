package se.liu.ida.oscth887oskth878.tddc69.project.network.packet.protocol;

import com.esotericsoftware.kryonet.Connection;
import se.liu.ida.oscth887oskth878.tddc69.project.network.NetworkConnection;
import se.liu.ida.oscth887oskth878.tddc69.project.server.Server;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Player;

/**
 * Packet that is sent from the client to the server as soon as a connection has been established.
 * Is used to give the player a name and the server a player to keep track of.
 *
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 17/09/2013
 */
public class InitPacket implements ProtocolPacket {
    private String name = "Player";

    public InitPacket() {
    }

    public InitPacket(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void onClientReceive(Connection connection) {
        // Do nothing. Only read by server.
    }

    @Override
    public void onServerReceive(NetworkConnection connection) {
        Player player = Server.addPlayer(this.getName());
        if (player != null) {
            connection.setPlayer(player);
            System.out.println("\"" + player.getName() + "\" connected to server, and is on team: " + player.getTeam());
            connection.sendTCP(new ConnectionEstablishedPacket(player));
        }
        else {
            System.out.println("\"" + this.getName() + "\" tried to connect when server is full");
            connection.sendTCP(new TerminatePacket("Server full"));
        }
    }
}
