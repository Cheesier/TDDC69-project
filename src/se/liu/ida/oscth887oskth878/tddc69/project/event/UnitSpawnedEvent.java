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
public class UnitSpawnedEvent extends Event {
    private final Unit unit;
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

    // Only logic to set this to true, setting it to false would ignore what a listener has to say
    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }
}
