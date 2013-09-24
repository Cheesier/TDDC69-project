package se.liu.ida.oscth887oskth878.tddc69.project.Client;

import se.liu.ida.oscth887oskth878.tddc69.project.Network.Client.GameClient;

/**
 * Created with IntelliJ IDEA.
 * User: Oscar
 * Date: 2013-09-15
 * Time: 19:55
 */
public class Client {
    public static void main(String[] args) {
        GameClient server = new GameClient();

        try {
            Thread.sleep(10000l);
            server.close("End of game");
        } catch (InterruptedException e) {
        }
    }
}
