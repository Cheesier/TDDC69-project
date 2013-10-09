package se.liu.ida.oscth887oskth878.tddc69.project.network;

import com.esotericsoftware.kryo.Kryo;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.Packet;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.game.GamePacket;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.game.StartGamePacket;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.game.TowerPacket;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.game.TowerPlacedPacket;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.protocol.ConnectionEstablishedPacket;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.protocol.InitPacket;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.protocol.ProtocolPacket;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.protocol.TerminatePacket;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.*;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.towers.BasicTower;

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
        kryo.register(ConnectionEstablishedPacket.class);
        kryo.register(InitPacket.class);
        kryo.register(TerminatePacket.class);

        kryo.register(GamePacket.class);
        kryo.register(StartGamePacket.class);
        kryo.register(TowerPacket.class);
        kryo.register(TowerPlacedPacket.class);

        kryo.register(Level.class);
        kryo.register(Tile.class);
        kryo.register(Tower.class);
        kryo.register(TowerFactory.TowerType.class);
        kryo.register(Unit.class);
        kryo.register(UnitFactory.UnitType.class);

        kryo.register(Player.class);
        kryo.register(Player.Team.class);

    }
}
