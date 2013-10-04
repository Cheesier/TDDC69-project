package se.liu.ida.oscth887oskth878.tddc69.project.util;

import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Level;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Unit;
import se.liu.ida.oscth887oskth878.tddc69.project.util.AStar.AStar;
import se.liu.ida.oscth887oskth878.tddc69.project.util.AStar.GoalNode;
import se.liu.ida.oscth887oskth878.tddc69.project.util.AStar.ISearchNode;
import se.liu.ida.oscth887oskth878.tddc69.project.util.AStar.SearchNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

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

        // Using: https://github.com/jonasnick/A-star

        GoalNode goalNode = new GoalNode((int)destination.x, (int)destination.y);
        SearchNode initialNode = new SearchNode((int)unit.getLocation().x, (int)unit.getLocation().y, null, goalNode);
        ArrayList<ISearchNode> path = new AStar(level, unit).shortestPath(initialNode, goalNode);

        Iterator<ISearchNode> itr = path.iterator();

        Path result = new Path();

        while (itr.hasNext()) {
            SearchNode node = (SearchNode)itr.next();
            result.addPoint(node.getX(), node.getY());
        }

        return result;
    }
}
