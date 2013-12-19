package se.liu.ida.oscth887oskth878.tddc69.project.network.packet.protocol;

import com.esotericsoftware.kryonet.Connection;
import se.liu.ida.oscth887oskth878.tddc69.project.network.NetworkConnection;

import javax.swing.*;

/**
 * Packet that is used for ending a connection to the server or client,
 * example: Sever is full or game is over.
 *
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 17/09/2013
 */
public class TerminatePacket implements ProtocolPacket {
    private String reason = "Not specified";

    public TerminatePacket() {
    }

    public TerminatePacket(String reason) {
        this.reason = reason;
    }

    @Override
    public void onClientReceive(Connection connection) {
        System.out.println("Disconnecting from server, reason: " + this.reason);
        connection.close();

        // fun way to tell the user the game disconnected
        JOptionPane.showInputDialog("Disconnected from server, reason: " + this.reason +
                ".\nHow sad are you now?", "Very");
        System.exit(0);
    }

    @Override
    public void onServerReceive(NetworkConnection connection) {

    }
}
