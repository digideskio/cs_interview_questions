package graph;

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

        // Do a depth-first search starting on n1 if n2 is connected, if
        // so, then return true, otherwise, false.
        // TODO: need to create a state (visited/unvisited) 
        
    }
}
