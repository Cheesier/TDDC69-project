package se.liu.ida.oscth887oskth878.tddc69.project.util.AStar;

import java.util.ArrayList;

/**
 * Interface of a search node.
 */
@SuppressWarnings("ALL")
public interface ISearchNode extends Comparable<ISearchNode> {
    // total estimated cost of the node
    public double f();
    //"tentative" g, cost from the start node 
    public double g();
    //set "tentative" g
    public void setG(double g);
    //heuristic cost to the goal node
    public double h();
    //costs to a successor
    public double c(ISearchNode successor);
    // a node possesses or computes his successors
    public ArrayList<ISearchNode> getSuccessors();
    // get parent of node in a path
    public ISearchNode getParent();
    //set parent
    public void setParent(ISearchNode parent);

    public boolean equals(Object other);

    public int hashCode();
}

