package se.liu.ida.oscth887oskth878.tddc69.project.network.client;

import com.esotericsoftware.kryonet.Connection;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.protocol.ProtocolPacket;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.protocol.TerminatePacket;

/**
 * Created with IntelliJ IDEA.
 * User: ostenip
 * Date: 9/17/13
 * Time: 3:04 AM
 * To change this template use File | Settings | File Templates.
 */
public class ProtocolHandler {
    public static void handle(Connection connection, ProtocolPacket packet) {
        if (packet instanceof TerminatePacket) {
            System.out.println("Disconnecting from server, reason: " + ((TerminatePacket) packet).getReason());
            connection.close();
        }
    }
}
