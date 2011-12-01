package graph;

import java.util.Set;
import java.util.HashSet;

/**
 * Graph datastructure implementation.
 *
 * @author Chris Arriola
 */
public class Graph {

    Set<GraphNode> nodes;    

    public Graph() {
        nodes = new HashSet<GraphNode>();
    }

    public void add(GraphNode n) {
        nodes.add(n);
    }

    public void delete(GraphNode n) {
        nodes.remove(n);
    }

    public Set<GraphNode> getNodes() {
        return nodes;
    }

    public void setAllNodesUnvisited() {
        for (GraphNode node : nodes) {
            node.setState(GraphState.UNVISITED);
        }
    }

    public int size() {
        return nodes.size();
    }
}
