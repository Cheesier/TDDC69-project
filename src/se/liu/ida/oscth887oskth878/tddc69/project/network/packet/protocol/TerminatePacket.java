package se.liu.ida.oscth887oskth878.tddc69.project.network.packet.protocol;

/**
 * Packet that is used for ending a connection to the server or client,
 * example: Sever is full or game is over.
 *
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 17/09/2013
 */
public class TerminatePacket implements ProtocolPacket {
    private String reason = "Not specified";

    public TerminatePacket() {
    }

    public TerminatePacket(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }
}
