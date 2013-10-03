package se.liu.ida.oscth887oskth878.tddc69.project.simulation.units;

import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Player;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Unit;
import se.liu.ida.oscth887oskth878.tddc69.project.util.Pointf;

/**
 * @version 1.0
 * @author: Oskar Therén
 * @author: Oscar Thunberg
 * @since: 24/09/2013
 */
public class BasicUnit extends Unit {
    public static final int hitpoints = 50;
    public static final MoveType moveType = MoveType.GROUND;
    public static final float speed = 0.1f;

    public BasicUnit(Pointf position, Player.Team owner) {
        super(position, owner, hitpoints, moveType, speed);
    }
}
