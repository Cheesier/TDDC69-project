package se.liu.ida.oscth887oskth878.tddc69.project.network.client;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.Packet;

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
    public void received (Connection connection, Object packet) {
        if (packet instanceof Packet) {
            ((Packet) packet).onClientReceive(connection);
        }
    }

    @Override
    public void disconnected(Connection connection) {
        super.disconnected(connection);
        System.out.println("Connection ended suddenly");
        System.exit(1);
    }
}
