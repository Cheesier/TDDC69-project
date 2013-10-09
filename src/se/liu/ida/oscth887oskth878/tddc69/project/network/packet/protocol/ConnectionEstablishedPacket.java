package se.liu.ida.oscth887oskth878.tddc69.project.network.packet.protocol;

import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Player;

/**
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 09/10/2013
 */
public class ConnectionEstablishedPacket extends ProtocolPacket {
    private Player player;

    public ConnectionEstablishedPacket() {
    }

    public ConnectionEstablishedPacket(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
