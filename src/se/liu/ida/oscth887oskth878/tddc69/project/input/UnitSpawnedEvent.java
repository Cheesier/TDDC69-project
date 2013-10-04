package se.liu.ida.oscth887oskth878.tddc69.project.input;

import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Unit;

/**
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 04/10/2013
 */
public class UnitSpawnedEvent {
    private Unit unit;

    public UnitSpawnedEvent(Unit unit) {
        this.unit = unit;
    }

    public Unit getUnit() {
        return unit;
    }
}
