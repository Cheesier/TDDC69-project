package se.liu.ida.oscth887oskth878.tddc69.project.network.server;

import com.esotericsoftware.kryonet.Server;
import se.liu.ida.oscth887oskth878.tddc69.project.network.Network;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: ostenip
 * Date: 9/13/13
 * Time: 7:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class GameServer {
    public final int LISTERNER_PORT;

    public static void main(String[] args) {
        if (args.length == 1) {
            new GameServer(Integer.parseInt(args[0]));
        }
        else if (args.length > 1) {
            System.out.println("Too many arguments, ignoring that.");
        }
        else {
            new GameServer();
        }
    }

    public GameServer() {
        this(Network.DEFAULT_PORT);
    }

    public GameServer(int port) {
        LISTERNER_PORT = port;

        Server server = new Server();
        try {
            Network.registerClasses(server.getKryo());
            server.start();
            server.bind(LISTERNER_PORT);

            System.out.println("Started server on port " + LISTERNER_PORT);

            server.addListener(new PacketHandler());
        } catch (IOException e) {
            System.err.println("Could not bind to port: " + LISTERNER_PORT);
            e.printStackTrace();
            System.exit(0);
        }
    }
}
