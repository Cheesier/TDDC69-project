package se.liu.ida.oscth887oskth878.tddc69.project.network.client;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import se.liu.ida.oscth887oskth878.tddc69.project.network.Network;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.Packet;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.protocol.InitPacket;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.protocol.TerminatePacket;

import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * The game client itself, starts a new connection to the server and maintains all network traffic.
 *
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 17/09/2013
 */
public class GameClient {
    private final Client client;
    private final ConcurrentLinkedQueue<Connection> connectionQueue = new ConcurrentLinkedQueue<Connection>();
    private final ConcurrentLinkedQueue<Packet> packetQueue = new ConcurrentLinkedQueue<Packet>();
    private final PacketHandler packetHandler = new PacketHandler();

    public GameClient(String address, int port) {
        client = new Client();
        client.start();

        try {
            Network.registerClasses(client.getKryo());
            client.connect(5000, address, port);
            client.addListener(new Listener() {
                public void received(Connection connection, Object packet) {
                    if (packet instanceof Packet) {
                        connectionQueue.add(connection);
                        packetQueue.add((Packet) packet);
                    }
                }
            });
            System.out.println("Connected to server.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handshake(String name) {
        client.sendTCP(new InitPacket(name));
    }

    public void update() {
        Packet packet;
        while ((packet = packetQueue.poll()) != null) {
            packetHandler.received(connectionQueue.poll(), packet);
        }
    }

    public void send(Packet packet) {
        client.sendTCP(packet);
    }

    // For now we only close the connection when the client closes the window
    public void close(String reason) {
        client.sendTCP(new TerminatePacket(reason));
        client.close();
    }
}
