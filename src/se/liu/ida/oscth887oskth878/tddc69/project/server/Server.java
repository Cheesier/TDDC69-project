package se.liu.ida.oscth887oskth878.tddc69.project.server;

import se.liu.ida.oscth887oskth878.tddc69.project.network.server.GameServer;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Player;

/**
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 09/10/2013
 */
public class Server {
    public static Player[] players = new Player[2];
    private static GameServer server;

    public static void main(String[] args) {
        if (args.length == 1) {
            server = new GameServer(Integer.parseInt(args[0]));
        }
        else if (args.length > 1) {
            System.out.println("Too many arguments, ignoring that.");
        }
        else {
            server = new GameServer();
        }
    }

    public static Player addPlayer(String name) {
        if (players[0] == null) {
            players[0] = new Player(Player.Team.BLUE, name);
            return players[0];
        }
        else if (players[1] == null) {
            players[1] = new Player(Player.Team.RED, name);
            return players[1];
        }
        else {
            return null;
        }
    }

    public static GameServer getServer() {
        return server;
    }
}
