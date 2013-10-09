package se.liu.ida.oscth887oskth878.tddc69.project.network.packet.game;

import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Player;
import se.liu.ida.oscth887oskth878.tddc69.project.util.Point;

/**
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 09/10/2013
 */
public class TowerPacket extends GamePacket {
    private Player player;
    private Point position;

    public TowerPacket() {
    }

    protected TowerPacket(Player player, Point position) {
        this.player = player;
        this.position = position;
    }

    public Player getPlayer() {
        return player;
    }

    public Point getPosition() {
        return position;
    }
}
