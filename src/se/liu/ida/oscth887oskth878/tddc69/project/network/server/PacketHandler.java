package se.liu.ida.oscth887oskth878.tddc69.project.network.server;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import se.liu.ida.oscth887oskth878.tddc69.project.network.NetworkConnection;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.game.GamePacket;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.protocol.ProtocolPacket;
import se.liu.ida.oscth887oskth878.tddc69.project.server.Server;

/**
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 17/09/2013
 */
public class PacketHandler extends Listener {
    public void received (Connection c, Object packet) {
        NetworkConnection connection = (NetworkConnection)c;
        if (packet instanceof ProtocolPacket) {
            ProtocolHandler.handle(connection, (ProtocolPacket)packet);
        }
        else if (packet instanceof GamePacket) {
            GameHandler.handle(connection, (GamePacket)packet);
        }
    }

    @Override
    public void disconnected(Connection c) {
        NetworkConnection connection = (NetworkConnection)c;
        if (connection.getPlayer() != null)
            System.out.println("\"" + connection.getPlayer().getName() + "\" disconnected.");

        for (int i = 0; i < Server.players.length; i++) {
            if (Server.players[i].equals(connection.getPlayer())) {
                Server.players[i] = null;
                break;
            }
        }

        super.disconnected(connection);
    }
}
