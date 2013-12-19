package se.liu.ida.oscth887oskth878.tddc69.project.network.packet.game;

import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Player;
import se.liu.ida.oscth887oskth878.tddc69.project.util.Point;

/**
 * Base for all <code>Tower</code> based packets.
 *
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 09/10/2013
 */
public abstract class TowerPacket implements GamePacket {
    private Player player = null;
    private Point position = null;

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
