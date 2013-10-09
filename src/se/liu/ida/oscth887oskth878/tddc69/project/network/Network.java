package se.liu.ida.oscth887oskth878.tddc69.project.network;

import com.esotericsoftware.kryo.Kryo;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.Packet;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.protocol.InitPacket;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.protocol.ProtocolPacket;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.protocol.TerminatePacket;

/**
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 17/09/2013
 */
public class Network {
    public static final int DEFAULT_PORT = 22400;

    public static void registerClasses(Kryo kryo) {
        kryo.register(Packet.class);

        kryo.register(ProtocolPacket.class);
        kryo.register(InitPacket.class);
        kryo.register(TerminatePacket.class);
    }
}
