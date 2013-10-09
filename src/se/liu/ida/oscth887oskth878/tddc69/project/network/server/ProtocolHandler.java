package se.liu.ida.oscth887oskth878.tddc69.project.network.server;

import se.liu.ida.oscth887oskth878.tddc69.project.network.NetworkConnection;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.protocol.ConnectionEstablishedPacket;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.protocol.InitPacket;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.protocol.ProtocolPacket;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.protocol.TerminatePacket;
import se.liu.ida.oscth887oskth878.tddc69.project.server.Server;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Player;

/**
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 17/09/2013
 */
public class ProtocolHandler {
    public static void handle(NetworkConnection connection, ProtocolPacket packet) {
        if (packet instanceof InitPacket) {
            Player player = Server.addPlayer(((InitPacket) packet).getName());
            if (player != null) {
                connection.setPlayer(player);
                System.out.println("\"" + player.getName() + "\" connected to server, and is on team: " + player.getTeam());
                connection.sendTCP(new ConnectionEstablishedPacket(player));
            }
            else {
                System.out.println("\"" + ((InitPacket) packet).getName() + "\" tried to connect when server is full");
                connection.sendTCP(new TerminatePacket("Server full"));
            }
        }
        else if (packet instanceof TerminatePacket) {
            System.out.println("\"" + connection.getPlayer().getName() + "\" terminating connection (" + ((TerminatePacket) packet).getReason() + ")");
            connection.close();
        }
    }
}
