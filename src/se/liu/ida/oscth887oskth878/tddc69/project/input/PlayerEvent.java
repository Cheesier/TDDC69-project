package se.liu.ida.oscth887oskth878.tddc69.project.input;

import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Player;

/**
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 09/10/2013
 */
public abstract class PlayerEvent extends Event {
    private Player player;

    protected PlayerEvent(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
