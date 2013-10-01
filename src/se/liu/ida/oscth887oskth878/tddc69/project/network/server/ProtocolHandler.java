package se.liu.ida.oscth887oskth878.tddc69.project.network.server;

import com.esotericsoftware.kryonet.Connection;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.protocol.InitPacket;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.protocol.ProtocolPacket;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.protocol.TerminatePacket;

/**
 * Created with IntelliJ IDEA.
 * User: ostenip
 * Date: 9/17/13
 * Time: 2:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class ProtocolHandler {
    public static void handle(Connection connection, ProtocolPacket packet) {
        if (packet instanceof InitPacket) {
            System.out.println(((InitPacket) packet).getName() + " just connected.");
        }
        else if (packet instanceof TerminatePacket) {
            System.out.println("Client terminated connection (" + ((TerminatePacket) packet).getReason() + ")");
            connection.close();
        }
    }
}
