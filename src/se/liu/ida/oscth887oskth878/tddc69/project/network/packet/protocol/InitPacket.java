package se.liu.ida.oscth887oskth878.tddc69.project.network.packet.protocol;

/**
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
