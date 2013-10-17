package se.liu.ida.oscth887oskth878.tddc69.project.simulation.units;

import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Player;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.UnitFactory;
import se.liu.ida.oscth887oskth878.tddc69.project.util.Pointf;

/**
 * @author Oskar Therén
 * @author Oscar Thunberg
 * @version 1.0
 * @since 24/09/2013
 */
public class BasicUnit extends Unit {
    public static final int hitpoints = 50;
    public static final MoveType moveType = MoveType.GROUND;
    public static final float speed = 0.1f;
    public static final UnitFactory.UnitType UNIT_TYPE = UnitFactory.UnitType.BASIC_UNIT;

    public BasicUnit(Pointf position, Player.Team owner) {
        super(position, owner, hitpoints, moveType, speed, UNIT_TYPE);
    }
}
