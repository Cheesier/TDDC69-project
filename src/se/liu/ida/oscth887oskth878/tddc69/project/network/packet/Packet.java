package se.liu.ida.oscth887oskth878.tddc69.project.network.packet;

import com.esotericsoftware.kryonet.Connection;
import se.liu.ida.oscth887oskth878.tddc69.project.network.NetworkConnection;

/**
 * Base for every packet that needs to be sent over the network, to or from clients.
 *
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 15/09/2013
 */
public interface Packet {

    public void onClientReceive(Connection connection);
    public void onServerReceive(NetworkConnection connection);
}
