package se.liu.ida.oscth887oskth878.tddc69.project.Util;

import se.liu.ida.oscth887oskth878.tddc69.project.Simulation.Level;
import se.liu.ida.oscth887oskth878.tddc69.project.Simulation.Unit;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: ostenip
 * Date: 9/16/13
 * Time: 3:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class Astar implements Pathfinding {
    @Override
    public Path findPath(Unit unit, Pointf destination, Level level) {
        ArrayList<Point> open = new ArrayList<Point>();   // to be evaluated
        ArrayList<Point> closed = new ArrayList<Point>(); // has been evaluated

        //open.add(unit.getLocation());

        return new Path();
    }
}
