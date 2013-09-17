package se.liu.ida.oscth887oskth878.tddc69.project.Packet.Protocol;

/**
 * Created with IntelliJ IDEA.
 * User: ostenip
 * Date: 9/17/13
 * Time: 2:27 AM
 * To change this template use File | Settings | File Templates.
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
