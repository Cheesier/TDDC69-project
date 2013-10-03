package se.liu.ida.oscth887oskth878.tddc69.project.util.AStar;

/**
 * GoalNodes don't need as much Information
 * as SearchNodes.
 */
public interface IGoalNode{
    public boolean inGoal(ISearchNode other);
} 
