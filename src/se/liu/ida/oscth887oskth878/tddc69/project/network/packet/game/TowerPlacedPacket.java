package se.liu.ida.oscth887oskth878.tddc69.project.network.packet.game;

import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Player;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.TowerFactory;
import se.liu.ida.oscth887oskth878.tddc69.project.util.Point;

/**
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 09/10/2013
 */
public class TowerPlacedPacket extends TowerPacket {
    private TowerFactory.TowerType towerType;

    public TowerPlacedPacket() {
    }

    public TowerPlacedPacket(Player player, Point position, TowerFactory.TowerType towerType) {
        super(player, position);
        this.towerType = towerType;
    }

    public TowerFactory.TowerType getTowerType() {
        return towerType;
    }
}
