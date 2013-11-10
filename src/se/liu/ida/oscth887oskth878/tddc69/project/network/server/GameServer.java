package se.liu.ida.oscth887oskth878.tddc69.project.network.server;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Server;
import se.liu.ida.oscth887oskth878.tddc69.project.network.Network;
import se.liu.ida.oscth887oskth878.tddc69.project.network.NetworkConnection;
import se.liu.ida.oscth887oskth878.tddc69.project.network.packet.Packet;

import java.io.IOException;

/**
 * Handles all the network activity from client, different packets are handled by different handlers.
 * GamePackets are handled in <code>GameHandler</code>, ProtocolPackets are handled in <code>ProtocolHandler</code>.
 *
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 13/09/2013
 */
@SuppressWarnings("FieldCanBeLocal")
public class GameServer {
    private final int LISTENER_PORT;
    private Server server;

    public GameServer() {
        this(Network.DEFAULT_PORT);
    }

    public GameServer(int port) {
        LISTENER_PORT = port;

        server = new Server() {
            protected Connection newConnection () {
                // By providing our own connection implementation, we can store per
                // connection state without a connection ID to state look up.
                return new NetworkConnection();
            }
        };

        try {
            Network.registerClasses(server.getKryo());
            server.start();
            server.bind(LISTENER_PORT);

            System.out.println("Started server on port " + LISTENER_PORT);

            server.addListener(new PacketHandler());
        } catch (IOException e) {
            System.err.println("Could not bind to port: " + LISTENER_PORT);
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void close() {
        server.close();
    }

    public void sendToAllExcept(int id, Packet packet) {
        server.sendToAllExceptTCP(id, packet);
    }
}
