package se.liu.ida.oscth887oskth878.tddc69.project.network.client;

import com.esotericsoftware.kryonet.Connection;
import se.liu.ida.oscth887oskth878.tddc69.project.input.InputManager;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.game.GamePacket;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.game.TowerPlacedPacket;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.game.TowerRemovedPacket;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.game.UnitSpawnedPacket;

/**
 * Handles all the game specific packets.
 *
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 09/10/2013
 */
public class GamePacketHandler {
    public static void handle(Connection connection, GamePacket incomingPacket) {
        if (incomingPacket instanceof TowerPlacedPacket) {
            TowerPlacedPacket packet = (TowerPlacedPacket)incomingPacket;
            InputManager.placeTower(packet.getPlayer(), packet.getTowerType(), packet.getPosition());
        }
        else if (incomingPacket instanceof TowerRemovedPacket) {
            TowerRemovedPacket packet = (TowerRemovedPacket)incomingPacket;
            InputManager.removeTower(packet.getPlayer(), packet.getPosition());
        }
        else if (incomingPacket instanceof UnitSpawnedPacket) {
            UnitSpawnedPacket packet = (UnitSpawnedPacket) incomingPacket;
            InputManager.spawnUnit(packet.getUnitType(), packet.getTeam());
        }
    }
}
