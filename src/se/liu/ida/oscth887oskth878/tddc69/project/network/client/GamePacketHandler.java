package se.liu.ida.oscth887oskth878.tddc69.project.network.client;

import com.esotericsoftware.kryonet.Connection;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.game.GamePacket;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.game.TowerPlacedPacket;

/**
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 09/10/2013
 */
public class GamePacketHandler {
    public static void handle(Connection connection, GamePacket incomingPacket) {
        if (incomingPacket instanceof TowerPlacedPacket) {
            TowerPlacedPacket packet = (TowerPlacedPacket)incomingPacket;


        }
    }
}