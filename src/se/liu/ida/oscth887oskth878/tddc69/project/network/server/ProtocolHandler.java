package se.liu.ida.oscth887oskth878.tddc69.project.network.server;

import se.liu.ida.oscth887oskth878.tddc69.project.network.NetworkConnection;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.protocol.InitPacket;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.protocol.ProtocolPacket;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.protocol.TerminatePacket;

/**
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 17/09/2013
 */
public class ProtocolHandler {
    public static void handle(NetworkConnection connection, ProtocolPacket packet) {
        if (packet instanceof InitPacket) {
            System.out.println(((InitPacket) packet).getName() + " just connected.");

        }
        else if (packet instanceof TerminatePacket) {
            System.out.println("Client terminated connection (" + ((TerminatePacket) packet).getReason() + ")");
            connection.close();
        }
    }
}
