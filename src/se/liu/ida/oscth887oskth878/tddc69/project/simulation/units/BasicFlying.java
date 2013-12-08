package se.liu.ida.oscth887oskth878.tddc69.project.simulation.units;

import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Player;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.UnitFactory;
import se.liu.ida.oscth887oskth878.tddc69.project.util.Pointf;

/**
 * @author Oskar Therén
 * @author Oscar Thunberg
 * @version 1.0
 * @since 07/10/2013
 */
public class BasicFlying extends Unit {
    private static final int hitpoints = 40;
    private static final MoveType moveType = MoveType.AIR;
    private static final float speed = 0.2f;
    private static final UnitFactory.UnitType UNIT_TYPE = UnitFactory.UnitType.BASIC_FLYING;

    public BasicFlying(Pointf position, Player.Team owner) {
        super(position, owner, hitpoints, moveType, speed, UNIT_TYPE);
    }
}
