package se.liu.ida.oscth887oskth878.tddc69.project.network.server;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import se.liu.ida.oscth887oskth878.tddc69.project.network.NetworkConnection;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.Packet;
import se.liu.ida.oscth887oskth878.tddc69.project.server.Server;

/**
 * Splits all the incoming packets up to simplify handling.
 *
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 17/09/2013
 */
public class PacketHandler extends Listener {
    @SuppressWarnings("RefusedBequest") // library not written by someone else, suppressing error from it
    public void received (Connection con, Object packet) {
        NetworkConnection connection = (NetworkConnection)con;
        if (packet instanceof Packet) {
            ((Packet) packet).onServerReceive(connection);
        }
    }

    @Override
    public void disconnected(Connection con) {
        NetworkConnection connection = (NetworkConnection)con;
        if (connection.getPlayer() != null)
            System.out.println("\"" + connection.getPlayer().getName() + "\" disconnected.");

        for (int i = 0; i < Server.getPlayers().length; i++) {

            if (Server.getPlayers()[i] != null && Server.getPlayers()[i].equals(connection.getPlayer())) {
                Server.getPlayers()[i] = null;
                break;
            }
        }

        super.disconnected(connection);
    }
}
