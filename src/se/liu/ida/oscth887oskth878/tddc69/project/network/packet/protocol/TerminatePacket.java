package se.liu.ida.oscth887oskth878.tddc69.project.network.packet.protocol;

/**
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 17/09/2013
 */
public class TerminatePacket extends ProtocolPacket {
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
