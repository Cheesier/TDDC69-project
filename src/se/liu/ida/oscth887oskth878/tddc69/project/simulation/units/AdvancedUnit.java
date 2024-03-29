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
@SuppressWarnings("WeakerAccess")
public class AdvancedUnit extends Unit {
    public static final int hitpoints = 50;
    public static final MoveType moveType = MoveType.GROUND;
    public static final float speed = 0.3f;
    public static final UnitFactory.UnitType UNIT_TYPE = UnitFactory.UnitType.ADVANCED_UNIT;

    public AdvancedUnit(Pointf position, Player.Team owner) {
        super(position, owner, hitpoints, moveType, speed, UNIT_TYPE);
    }
}
