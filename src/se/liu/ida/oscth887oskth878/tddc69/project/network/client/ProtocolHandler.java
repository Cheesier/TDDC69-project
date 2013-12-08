package se.liu.ida.oscth887oskth878.tddc69.project.network.client;

import com.esotericsoftware.kryonet.Connection;
import org.lwjgl.opengl.Display;
import se.liu.ida.oscth887oskth878.tddc69.project.client.Client;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.protocol.ConnectionEstablishedPacket;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.protocol.ProtocolPacket;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.protocol.TerminatePacket;

import javax.swing.*;

/**
 * Handle all the different <code>ProtocolPacket</code>s used in the game.
 *
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 17/09/2013
 */
public final class ProtocolHandler {
    private ProtocolHandler() {
    }

    public static void handle(Connection connection, ProtocolPacket packet) {
        if (packet instanceof ConnectionEstablishedPacket) {
            ConnectionEstablishedPacket cePacket = ((ConnectionEstablishedPacket) packet);
            System.out.println("I am: " + cePacket.getPlayer().getTeam());
            Display.setTitle(cePacket.getPlayer().getName() + " playing on team " + cePacket.getPlayer().getTeam());
            Client.player = ((ConnectionEstablishedPacket) packet).getPlayer();
        }
        else if (packet instanceof TerminatePacket) {
            System.out.println("Disconnecting from server, reason: " + ((TerminatePacket) packet).getReason());
            connection.close();

            // fun way to tell the user the game disconnected
            JOptionPane.showInputDialog("Disconnected from server, reason: " + ((TerminatePacket) packet).getReason() +
                    ".\nHow sad are you now?", "Very");
            System.exit(0);
        }
    }
}
