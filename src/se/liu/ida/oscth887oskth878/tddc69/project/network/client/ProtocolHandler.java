package se.liu.ida.oscth887oskth878.tddc69.project.network.client;

import com.esotericsoftware.kryonet.Connection;
import se.liu.ida.oscth887oskth878.tddc69.project.client.Client;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.protocol.ConnectionEstablishedPacket;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.protocol.ProtocolPacket;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.protocol.TerminatePacket;

/**
 * Handle all the different <code>ProtocolPacket</code>s used in the game.
 *
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 17/09/2013
 */
public class ProtocolHandler {
    public static void handle(Connection connection, ProtocolPacket packet) {
        if (packet instanceof ConnectionEstablishedPacket) {
            System.out.println("I am: " + ((ConnectionEstablishedPacket) packet).getPlayer().getTeam());
            Client.player = ((ConnectionEstablishedPacket) packet).getPlayer();
        }
        else if (packet instanceof TerminatePacket) {
            System.out.println("Disconnecting from server, reason: " + ((TerminatePacket) packet).getReason());
            connection.close();
        }
    }
}
