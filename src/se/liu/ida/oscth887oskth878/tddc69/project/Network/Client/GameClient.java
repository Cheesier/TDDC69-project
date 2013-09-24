package se.liu.ida.oscth887oskth878.tddc69.project.Network.Client;

import com.esotericsoftware.kryonet.Client;
import se.liu.ida.oscth887oskth878.tddc69.project.Network.Packet.Protocol.InitPacket;
import se.liu.ida.oscth887oskth878.tddc69.project.Network.Packet.Protocol.TerminatePacket;
import se.liu.ida.oscth887oskth878.tddc69.project.Network.Network;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: ostenip
 * Date: 9/17/13
 * Time: 2:57 AM
 * To change this template use File | Settings | File Templates.
 */
public class GameClient {
    Client client;

    public GameClient() {
        this(Network.DEFAULT_PORT);
    }

    public GameClient(int port) {
        client = new Client();
        client.start();

        try {
            Network.registerClasses(client.getKryo());
            client.connect(5000, "localhost", port);
            client.addListener(new PacketHandler());
            System.out.println("Connected to server.");

            client.sendTCP(new InitPacket("Ost"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close(String reason) {
        client.sendTCP(new TerminatePacket(reason));
        client.close();
    }
}
