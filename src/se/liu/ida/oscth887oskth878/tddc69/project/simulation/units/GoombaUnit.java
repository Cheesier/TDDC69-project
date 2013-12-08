package se.liu.ida.oscth887oskth878.tddc69.project.simulation.units;

import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Player;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.UnitFactory;
import se.liu.ida.oscth887oskth878.tddc69.project.util.Pointf;

/**
 * @author Oskar Therén
 * @author Oscar Thunberg
 * @version 1.0
 * @since 14/10/2013
 */
public class GoombaUnit extends Unit {
    private static final int HITPOINTS = 100;
    private static final MoveType MOVE_TYPE = MoveType.GROUND;
    private static final float SPEED = 0.2f;
    private static final UnitFactory.UnitType UNIT_TYPE = UnitFactory.UnitType.GOOMBA_UNIT;

    public GoombaUnit(Pointf position, Player.Team owner) {
        super(position, owner, HITPOINTS, MOVE_TYPE, SPEED, UNIT_TYPE);
    }
}
