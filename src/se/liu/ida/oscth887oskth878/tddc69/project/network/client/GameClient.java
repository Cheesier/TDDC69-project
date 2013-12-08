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
    Client client;
    private ConcurrentLinkedQueue<Connection> connectionQueue = new ConcurrentLinkedQueue<Connection>();
    private ConcurrentLinkedQueue<Packet> packetQueue = new ConcurrentLinkedQueue<Packet>();
    private PacketHandler packetHandler = new PacketHandler();
    private final int timeout = 5000;

    public GameClient(String address, int port) {
        client = new Client();
        client.start();

        try {
            Network.registerClasses(client.getKryo());
            client.connect(timeout, address, port);
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
        while (!packetQueue.isEmpty()) {
            packetHandler.received(connectionQueue.poll(), packetQueue.poll());
        }
    }

    public void send(Packet packet) {
        client.sendTCP(packet);
    }

    public void close(String reason) {
        client.sendTCP(new TerminatePacket(reason));
        client.close();
    }
}
