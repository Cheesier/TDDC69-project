package se.liu.ida.oscth887oskth878.tddc69.project.network.packet.game;

import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Player;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.UnitFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Oscar
 * Date: 2013-10-09
 * Time: 22:35
 */
public class UnitSpawnedPacket extends GamePacket {
    private UnitFactory.UnitType unitType;
    private Player.Team team;

    public UnitSpawnedPacket() {
    }

    public UnitSpawnedPacket(UnitFactory.UnitType unitType, Player.Team team) {
        this.unitType = unitType;
        this.team = team;
    }

    public UnitFactory.UnitType getUnitType() {
        return unitType;
    }

    public Player.Team getTeam() {
        return team;
    }
}
