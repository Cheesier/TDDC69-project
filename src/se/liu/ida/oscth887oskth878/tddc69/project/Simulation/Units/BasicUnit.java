package se.liu.ida.oscth887oskth878.tddc69.project.Simulation.Units;

import se.liu.ida.oscth887oskth878.tddc69.project.Simulation.Unit;

/**
 * @version 1.0
 * @author: Oskar Therén
 * @author: Oscar Thunberg
 * @since: 24/09/2013
 */
public class BasicUnit extends Unit {
    public static final int hitpoints = 50;
    public static final MoveType moveType = MoveType.GROUND;
    public static final int speed = 3;

    protected BasicUnit() {
        super(hitpoints, moveType, speed);
    }

    @Override
    public void onSelect() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
