package graph;

import java.util.Stack;
import java.util.Set;

/**
 * Class that contains methods for evaluating graphs.
 *
 * @author Chris Arriola
 */
public class Graphs {

    /**
     * Given a directed graph, evaluates i there is a rout between two nodes.
     */
    public static boolean hasRoute(Graph graph, GraphNode n1, GraphNode n2) {

        if (graph == null || n1 == null || n2 == null) {
            return false;
        }

        // Check if n1 and n2 are in the graph, if they're not, return false
        Set<GraphNode> nodes = graph.getNodes();
        if (!nodes.contains(n1) || !nodes.contains(n2)) {
            return false;
        }

        // Do a depth-first search (stack) starting on n1 if n2 is connected, if
        // so, then return true, otherwise, false.

        Stack<GraphNode> stack = new Stack<GraphNode>();        // For performing depth-first seach
        GraphNode currNode = n1;

        do {
            if (currNode == n2) {
                return true;
            }

            Set<GraphNode> toNodes = currNode.getToNodes();
            currNode.setState(GraphState.VISITED);

            for (GraphNode node : toNodes) {
                if (node.getState() == GraphState.UNVISITED) {
                    stack.push(node);
                }
            }

            currNode = stack.pop(); 
        } while (!stack.isEmpty());

        return false;
    }
}
