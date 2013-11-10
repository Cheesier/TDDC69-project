package se.liu.ida.oscth887oskth878.tddc69.project.event;

import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Player;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.TowerFactory;
import se.liu.ida.oscth887oskth878.tddc69.project.util.Point;

/**
 * Event for when a player removes a <code>Tower</code>.
 *
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 08/10/2013
 */
public class TowerRemovedEvent extends PlayerEvent {
    private TowerFactory.TowerType type;
    private Point position;
    private boolean canceled = false;

    public TowerRemovedEvent(Player player, TowerFactory.TowerType type, Point position) {
        super(player);
        this.type = type;
        this.position = position;
    }

    public TowerFactory.TowerType getType() {
        return type;
    }

    public Point getPosition() {
        return position;
    }

    public boolean isCanceled() {
        return canceled;
    }

    // Only logic to set this to true, setting it to false would ignore what a listener has to say
    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }
}
