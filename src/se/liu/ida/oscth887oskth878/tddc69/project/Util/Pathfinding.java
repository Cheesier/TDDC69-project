package se.liu.ida.oscth887oskth878.tddc69.project.util;

import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Level;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Unit;

/**
 * Created with IntelliJ IDEA.
 * User: ostenip
 * Date: 9/16/13
 * Time: 3:03 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Pathfinding {
    public Path findPath(Unit unit, Pointf destination, Level level);
}
