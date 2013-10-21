package se.liu.ida.oscth887oskth878.tddc69.project.network.packet.protocol;

/**
 * Packet that is sent from the client to the server as soon as a connection has been established.
 * Is used to give the player a name and the server a player to keep track of.
 *
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 17/09/2013
 */
public class InitPacket extends ProtocolPacket {
    private String name = "Player";

    public InitPacket() {
    }

    public InitPacket(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
