package se.liu.ida.oscth887oskth878.tddc69.project.Util;

import se.liu.ida.oscth887oskth878.tddc69.project.Simulation.Level;
import se.liu.ida.oscth887oskth878.tddc69.project.Simulation.Monster;

/**
 * Created with IntelliJ IDEA.
 * User: ostenip
 * Date: 9/16/13
 * Time: 3:03 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Pathfinding {
    public Point[] findPath(Monster monster, Point destination, Level level);
}
