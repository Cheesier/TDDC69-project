package se.liu.ida.oscth887oskth878.tddc69.project.Network.Packet.Protocol;

/**
 * Created with IntelliJ IDEA.
 * User: ostenip
 * Date: 9/17/13
 * Time: 2:24 AM
 * To change this template use File | Settings | File Templates.
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
