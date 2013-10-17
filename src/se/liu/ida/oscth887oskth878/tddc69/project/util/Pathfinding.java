package se.liu.ida.oscth887oskth878.tddc69.project.util;

import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Level;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.units.Unit;

/**
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 17/09/2013
 */
public interface Pathfinding {
    public Path findPath(Unit unit, Pointf destination, Level level);
}
