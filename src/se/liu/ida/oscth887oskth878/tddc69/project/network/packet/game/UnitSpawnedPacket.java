package se.liu.ida.oscth887oskth878.tddc69.project.network.packet.game;

import com.esotericsoftware.kryonet.Connection;
import se.liu.ida.oscth887oskth878.tddc69.project.event.EventManager;
import se.liu.ida.oscth887oskth878.tddc69.project.network.NetworkConnection;
import se.liu.ida.oscth887oskth878.tddc69.project.server.Server;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Player;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.UnitFactory;

/**
 * Notify other clients that a <code>Unit</code> should spawn.
 *
 * Created with IntelliJ IDEA.
 * User: Oscar
 * Date: 2013-10-09
 * Time: 22:35
 */
public class UnitSpawnedPacket implements GamePacket {
    private UnitFactory.UnitType unitType = null;
    private Player.Team team = null;

    public UnitSpawnedPacket() {
    }

    public UnitSpawnedPacket(UnitFactory.UnitType unitType, Player.Team team) {
        this.unitType = unitType;
        this.team = team;
    }

    @Override
    public void onClientReceive(Connection connection) {
        EventManager.spawnUnit(this.unitType, this.team);
    }

    @Override
    public void onServerReceive(NetworkConnection connection) {
        Server.getServer().sendToAllExcept(connection.getID(), this);
    }
}
