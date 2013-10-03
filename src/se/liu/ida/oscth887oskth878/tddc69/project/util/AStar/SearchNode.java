package se.liu.ida.oscth887oskth878.tddc69.project.util.AStar;

import java.util.ArrayList;

/**
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 04/10/2013
 */
public class SearchNode extends ASearchNode {
    private int x;
    private int y;
    private SearchNode parent;
    private GoalNode goal;

    public SearchNode(int x, int y, SearchNode parent, GoalNode goal) {
        this.x = x;
        this.y = y;
        this.parent = parent;
        this.goal = goal;
    }

    @Override
    public double h() {
        return this.dist(goal.getX(), goal.getY());
    }

    @Override
    public double c(ISearchNode successor) {
        //SearchNode successorNode = this.castToSearchNode(successor);
        return 1;
    }

    @Override
    public ArrayList<ISearchNode> getSuccessors() {
        ArrayList<ISearchNode> successors = new ArrayList<ISearchNode>();

        if (AStar.level.getTile(this.x-1, this.y).canPass(AStar.unit))
            successors.add(new SearchNode(this.x-1, this.y, this, this.goal));

        if (AStar.level.getTile(this.x+1, this.y).canPass(AStar.unit))
            successors.add(new SearchNode(this.x+1, this.y, this, this.goal));

        if (AStar.level.getTile(this.x, this.y+1).canPass(AStar.unit))
            successors.add(new SearchNode(this.x, this.y+1, this, this.goal));

        if (AStar.level.getTile(this.x, this.y-1).canPass(AStar.unit))
            successors.add(new SearchNode(this.x, this.y-1, this, this.goal));

        return successors;
    }

    @Override
    public ISearchNode getParent() {
        return this.parent;
    }

    @Override
    public void setParent(ISearchNode parent) {
        this.parent = this.castToSearchNode(parent);
    }

    public boolean equals(Object other) {
        if(other instanceof SearchNode) {
            SearchNode otherNode = (SearchNode) other;
            return (this.x == otherNode.getX()) && (this.y == otherNode.getY());
        }
        return false;
    }

    @Override
    public int compareTo(ISearchNode o) {
        SearchNode otherNode = this.castToSearchNode(o);
        if(this.f() < otherNode.f()) {
            return -1;
        } else if(this.f() == otherNode.f()) {
            return 0;
        } else {
            return 1;
        }
    }

    public int hashCode() {
        return (41 * (41 + this.x + this.y));
    }
    public double dist(int otherX, int otherY) {
        return Math.sqrt(Math.pow(this.x-otherX,2) + Math.pow(this.y-otherY,2));
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }

    public String toString(){
        return "(" + Integer.toString(this.x) + ";" + Integer.toString(this.y)
                + ";h:"+ Double.toString(this.h())
                + ";g:" +  Double.toString(this.g()) + ")";
    }

    private SearchNode castToSearchNode(ISearchNode other) {
        return (SearchNode) other;
    }
}
