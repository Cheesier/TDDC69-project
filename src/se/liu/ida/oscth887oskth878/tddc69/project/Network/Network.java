package se.liu.ida.oscth887oskth878.tddc69.project.Network;

import com.esotericsoftware.kryo.Kryo;
import se.liu.ida.oscth887oskth878.tddc69.project.Network.Packet.Packet;
import se.liu.ida.oscth887oskth878.tddc69.project.Network.Packet.Protocol.*;

/**
 * Created with IntelliJ IDEA.
 * User: ostenip
 * Date: 9/17/13
 * Time: 3:11 AM
 * To change this template use File | Settings | File Templates.
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