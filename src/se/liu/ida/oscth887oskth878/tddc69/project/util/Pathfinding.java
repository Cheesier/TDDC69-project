package se.liu.ida.oscth887oskth878.tddc69.project.util;

import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Level;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.units.Unit;

/**
 * Every algorithm for pathfinding in this game should implement this for easy replacement.
 *
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 17/09/2013
 */
public interface Pathfinding {
    public Path findPath(Unit unit, Pointf destination, Level level);
}
