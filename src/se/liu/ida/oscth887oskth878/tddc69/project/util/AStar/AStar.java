package se.liu.ida.oscth887oskth878.tddc69.project.util.AStar;

import se.liu.ida.oscth887oskth878.tddc69.project.simulation.Level;
import se.liu.ida.oscth887oskth878.tddc69.project.simulation.units.Unit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
/**
 * Uses the A* Algorithm to find the shortest path from 
 * an initial to a goal node.Nodes have to implement the
 * ISearchNode and IGoalNode interface respectively. 
 *
 */
@SuppressWarnings("ALL")
public class AStar {
    // Amount of debug output 0,1,2
    private int verbose = 0;
    // The maximum number of completed nodes. After that number the algorithm returns null.
    // If negative, the search will run until the goal node is found.
    private int maxSteps = -1;
    //number of search steps the AStar will perform after that null is returned
    private int numSearchSteps;
    
    public ISearchNode bestNodeAfterSearch;

    static Level level; // Ugly fix for a problem I don't want to deal with right now
    static Unit unit;

    public AStar(Level level, Unit unit) {
        AStar.level = level;
        AStar.unit = unit;
    }

    /**
     * Returns the shortest Path from a start node to an end node according to 
     * the A* heuristics (h must not overestimate). initialNode and last found node included.
     */
    public ArrayList<ISearchNode> shortestPath(ISearchNode initialNode, IGoalNode goalNode) {
        //perform search and save the 
        ISearchNode endNode = this.search(initialNode, goalNode);
        if(endNode == null) 
            return null;
        //return shortest path according to AStar heuristics
        return AStar.path(endNode);
    }
        

    /**
     * @param initialNode start of the search
     * @param goalNode end of the search
     * @return goal node from which you can reconstruct the path
     */
    public ISearchNode search(ISearchNode initialNode, IGoalNode goalNode) {
        PriorityQueue<ISearchNode> openSet = new PriorityQueue<ISearchNode>();
        openSet.add(initialNode);
        ArrayList<ISearchNode> closedSet = new ArrayList<ISearchNode>();
        // current iteration of the search
        this.numSearchSteps = 0;

        while(openSet.size() > 0 && (maxSteps < 0 || this.numSearchSteps < maxSteps)) {
            //get element with the least sum of costs from the initial node 
            //and heuristic costs to the goal 
            ISearchNode currentNode = openSet.poll();

            //debug output according to verbose
            if (verbose != 0)
                System.out.println((verbose>1 ? "Open set: " + openSet.toString() + "\n" : "")
                            + (verbose>0 ? "Current node: "+currentNode.toString()+"\n": "")
                            + (verbose>1 ? "Closed set: " + closedSet.toString() : ""));

            if(goalNode.inGoal(currentNode)) {
                //we know the shortest path to the goal node, done
                this.bestNodeAfterSearch = currentNode;
                return currentNode;
            }
            //get successor nodes
            ArrayList<ISearchNode> successorNodes = currentNode.getSuccessors();
            for(ISearchNode successorNode : successorNodes) {
                boolean inOpenSet;
                if(closedSet.contains(successorNode))
                    continue;
                /* Special rule for nodes that are generated within other nodes:
                 * We need to ensure that we use the node and
                 * its g value from the openSet if its already discovered
                 */
                ISearchNode discSuccessorNode = getNode(openSet, successorNode);
                if(discSuccessorNode != null) {
                    successorNode = discSuccessorNode;
                    inOpenSet = true;
                } else {
                    inOpenSet = false;
                }
                //compute tentativeG
                double tentativeG = currentNode.g() + currentNode.c(successorNode);
                //node was already discovered and this path is worse than the last one
                if(inOpenSet && tentativeG >= successorNode.g())
                    continue;
                successorNode.setParent(currentNode);
                if(inOpenSet) {
                    // if successorNode is already in data structure it has to be inserted again to 
                    // regain the order
                    openSet.remove(successorNode);
                    successorNode.setG(tentativeG);
                    openSet.add(successorNode);
                } else {
                    successorNode.setG(tentativeG);
                    openSet.add(successorNode);
                }
            }
            closedSet.add(currentNode);
            this.numSearchSteps += 1;
        }
        
        this.bestNodeAfterSearch = Collections.min(closedSet);
        return null;
    }

    /**
     * returns path from the earliest ancestor to the node in the argument
     * if the parents are set via AStar search, it will return the path found.
     * This is the shortest shortes path, if the heurstic h does not overestimate 
     * the true remaining costs
     * @param node node from which the parents are to be found. Parents of the node should
     *              have been properly set in preprocessing (f.e. AStar.search)
     * @return path to the node in the argument
     */
    public static ArrayList<ISearchNode> path(ISearchNode node) {
        ArrayList<ISearchNode> path = new ArrayList<ISearchNode>();
        path.add(node);
        ISearchNode currentNode = node;
        while(currentNode.getParent() != null) {
            ISearchNode parent = currentNode.getParent();
            path.add(0, parent);
            currentNode = parent;
        }
        return path; 
    }

    public int numSearchSteps() {
        return this.numSearchSteps;
    }

    public ISearchNode bestNodeAfterSearch() {
        return this.bestNodeAfterSearch;
    }

    public void setMaxSteps(int maxSteps) {
        this.maxSteps = maxSteps;
    }

    /**
     * returns the element from a PriorityQueue of ISearchNodes
     * @param queue queue to search in
     * @param searchedNode node we search
     * @return node from the queue
     */
    private static ISearchNode getNode(PriorityQueue<ISearchNode> queue, ISearchNode searchedNode) {
        for(ISearchNode openSearchNode : queue) {
            if(openSearchNode.equals(searchedNode)) {
                return openSearchNode;
            }
        }
        return null;
    }

}
