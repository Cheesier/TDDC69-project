package se.liu.ida.oscth887oskth878.tddc69.project.util;

import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Level;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.units.Unit;
import se.liu.ida.oscth887oskth878.tddc69.project.util.AStar.AStar;
import se.liu.ida.oscth887oskth878.tddc69.project.util.AStar.GoalNode;
import se.liu.ida.oscth887oskth878.tddc69.project.util.AStar.ISearchNode;
import se.liu.ida.oscth887oskth878.tddc69.project.util.AStar.SearchNode;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Implementation for the A* Pathfinding algorithm used to help a <code>Unit</code> find his way to a given point.
 *
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 16/09/2013
 */
public class Astar implements Pathfinding {
    @Override
    public Path findPath(Unit unit, Pointf destination, Level level) {

        // Using: https://github.com/jonasnick/A-star

        GoalNode goalNode = new GoalNode((int)destination.x, (int)destination.y);
        SearchNode initialNode = new SearchNode((int)unit.getLocation().x, (int)unit.getLocation().y, null, goalNode);
        ArrayList<ISearchNode> path = new AStar(level, unit).shortestPath(initialNode, goalNode);

        if (path == null)
            return null;

        Iterator<ISearchNode> itr = path.iterator();

        Path result = new Path();

        if (itr.hasNext()) // pop off the first element (the one the unit is already standing on)
            itr.next();

        while (itr.hasNext()) {
            SearchNode node = (SearchNode)itr.next();
            result.addPoint(node.getX(), node.getY());
        }

        return result;
    }
}
