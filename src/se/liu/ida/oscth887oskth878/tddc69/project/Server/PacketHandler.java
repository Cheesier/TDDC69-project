package se.liu.ida.oscth887oskth878.tddc69.project.Server;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import se.liu.ida.oscth887oskth878.tddc69.project.Packet.Protocol.ProtocolPacket;

/**
 * Created with IntelliJ IDEA.
 * User: ostenip
 * Date: 9/17/13
 * Time: 2:42 AM
 * To change this template use File | Settings | File Templates.
 */
public class PacketHandler extends Listener {
    public void received (Connection connection, Object packet) {
        if (packet instanceof ProtocolPacket) {
            ProtocolHandler.handle(connection, (ProtocolPacket)packet);
        }
    }
}
