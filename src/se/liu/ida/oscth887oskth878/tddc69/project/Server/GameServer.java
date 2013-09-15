package se.liu.ida.oscth887oskth878.tddc69.project.Server;

import com.esotericsoftware.kryonet.Server;

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
    public static final int DEFAULT_PORT = 22400;

    public static void main(String[] args) {
        if (args.length == 1) {
            new GameServer(Integer.parseInt(args[1]));
        }
        else if (args.length > 1) {
            System.out.println("Too many arguments, ignoring that.");
        }
        else {
            new GameServer(DEFAULT_PORT);
        }
    }

    public GameServer(int port) {
        LISTERNER_PORT = port;

        Server server = new Server();
        try {
            server.start();
            server.bind(LISTERNER_PORT);
        } catch (IOException e) {
            System.err.println("Could not bind to port: " + port);
            e.printStackTrace();
        }
    }
}
