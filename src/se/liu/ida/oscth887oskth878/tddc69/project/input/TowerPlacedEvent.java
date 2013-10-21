package se.liu.ida.oscth887oskth878.tddc69.project.input;

import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Player;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.TowerFactory;
import se.liu.ida.oscth887oskth878.tddc69.project.util.Point;

/**
 * Event for when a player places a <code>Tower</code>.
 *
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 04/10/2013
 */
public class TowerPlacedEvent extends PlayerEvent {
    private TowerFactory.TowerType type;
    private Point position;
    private boolean canceled = false;

    public TowerPlacedEvent(Player player, TowerFactory.TowerType type, Point position) {
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

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }
}
