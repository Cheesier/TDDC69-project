package se.liu.ida.oscth887oskth878.tddc69.project.util.AStar;

/**
 * @author Oscar Thunberg (oscth887)
 * @author Oskar Therén   (oskth878)
 * @version 1.0
 * @since 04/10/2013
 */
public class GoalNode implements IGoalNode {
    private int x;
    private int y;

    public GoalNode(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean inGoal(ISearchNode other) {
        if (other instanceof SearchNode) {
            SearchNode otherNode = (SearchNode) other;
            return (this.x == otherNode.getX()) && (this.y == otherNode.getY());
        }
        return false;
    }

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
}
