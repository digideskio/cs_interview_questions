package graph;

import java.util.Set;
import java.util.HashSet;

/**
 * Node in a graph
 *
 * @author Chris Arriola
 */
public class GraphNode {

    Graph graph;
    Set<GraphEdge> edges;    
    GraphState state;

    public GraphNode(Graph g) {
        edges = new HashSet<GraphEdge>();
        graph = g;
        state = GraphState.UNVISITED;
    }

    public void addEdge(GraphEdge e) {
        edges.add(e);
    }

    public GraphState getState() {
        return state;
    }

    public void setState(GraphState state) {
        this.state = state;
    }
    
    public Graph getGraph() {
        return graph;
    }

    public int getNumberOfEdges() {
        return edges.size();
    }

    public Set<GraphEdge> getEdges() {
        return edges;
    }

    public Set<GraphNode> getToNodes() {
        Set<GraphNode> nodes = new HashSet<GraphNode>();
        for (GraphEdge edge : edges) {
            nodes.add(edge.to);
        }
        return nodes;
    }
}
