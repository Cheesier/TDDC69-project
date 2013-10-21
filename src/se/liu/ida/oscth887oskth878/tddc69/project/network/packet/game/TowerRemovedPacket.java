package se.liu.ida.oscth887oskth878.tddc69.project.network.packet.game;

import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Player;
import se.liu.ida.oscth887oskth878.tddc69.project.util.Point;

/**
 * Notify other clients that a <code>Tower</code> should be removed.
 *
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 09/10/2013
 */
public class TowerRemovedPacket extends TowerPacket {

    public TowerRemovedPacket() {
    }

    public TowerRemovedPacket(Player player, Point position) {
        super(player, position);
    }
}
