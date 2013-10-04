package se.liu.ida.oscth887oskth878.tddc69.project.input;

import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Player;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.TowerFactory;
import se.liu.ida.oscth887oskth878.tddc69.project.util.Point;

/**
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 04/10/2013
 */
public class TowerPlacedEvent {
    private TowerFactory.TowerType type;
    private Point position;
    private Player.Team owner;

    public TowerPlacedEvent(TowerFactory.TowerType type, Point position, Player.Team owner) {
        this.type = type;
        this.position = position;
        this.owner = owner;
    }

    public TowerFactory.TowerType getType() {
        return type;
    }

    public Point getPosition() {
        return position;
    }

    public Player.Team getOwner() {
        return owner;
    }
}
