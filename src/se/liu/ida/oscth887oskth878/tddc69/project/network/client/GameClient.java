package se.liu.ida.oscth887oskth878.tddc69.project.network.client;

import com.esotericsoftware.kryonet.Client;
import se.liu.ida.oscth887oskth878.tddc69.project.network.Network;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.protocol.InitPacket;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.protocol.TerminatePacket;

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
