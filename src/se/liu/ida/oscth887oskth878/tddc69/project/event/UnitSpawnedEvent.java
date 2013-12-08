package se.liu.ida.oscth887oskth878.tddc69.project.event;

import se.liu.ida.oscth887oskth878.tddc69.project.simulation.units.Unit;

/**
 * Event for when a <code>Unit</code> spawns.
 *
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 04/10/2013
 */
public class UnitSpawnedEvent implements Event {
    private Unit unit;
    private boolean canceled = false;

    public UnitSpawnedEvent(Unit unit) {
        this.unit = unit;
    }

    public Unit getUnit() {
        return unit;
    }

    public boolean isCanceled() {
        return canceled;
    }
}
