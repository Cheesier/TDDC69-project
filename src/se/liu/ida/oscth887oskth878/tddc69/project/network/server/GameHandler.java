package se.liu.ida.oscth887oskth878.tddc69.project.network.server;

import se.liu.ida.oscth887oskth878.tddc69.project.network.NetworkConnection;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.game.GamePacket;
import se.liu.ida.oscth887oskth878.tddc69.project.server.Server;

/**
 * Handles all the <code>GamePacket</code>s that arrive to the server.
 *
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 09/10/2013
 */
public final class GameHandler {
    private GameHandler() {
    }

    public static void handle(NetworkConnection connection, GamePacket packet) {
        Server.getServer().sendToAllExcept(connection.getID(), packet);
    }
}
