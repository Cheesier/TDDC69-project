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
    private static final int HITPOINTS = 50;
    private static final MoveType MOVE_TYPE = MoveType.GROUND;
    private static final float SPEED = 0.1f;
    private static final UnitFactory.UnitType UNIT_TYPE = UnitFactory.UnitType.BASIC_UNIT;

    public BasicUnit(Pointf position, Player.Team owner) {
        super(position, owner, HITPOINTS, MOVE_TYPE, SPEED, UNIT_TYPE);
    }
}
