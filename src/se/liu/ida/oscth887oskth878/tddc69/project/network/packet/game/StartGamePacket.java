package se.liu.ida.oscth887oskth878.tddc69.project.network.packet.game;

import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Level;

/**
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 09/10/2013
 */
public class StartGamePacket extends GamePacket {
    private Level level;

    public StartGamePacket() {
    }

    public StartGamePacket(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }
}
