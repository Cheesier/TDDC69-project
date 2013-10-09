package se.liu.ida.oscth887oskth878.tddc69.project.network.client;

import com.esotericsoftware.kryonet.Listener;
import se.liu.ida.oscth887oskth878.tddc69.project.network.NetworkConnection;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.protocol.ProtocolPacket;

/**
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 17/09/2013
 */
public class PacketHandler extends Listener {
    public void received (NetworkConnection connection, Object packet) {
        if (packet instanceof ProtocolPacket) {
            ProtocolHandler.handle(connection, (ProtocolPacket)packet);
        }
    }
}
