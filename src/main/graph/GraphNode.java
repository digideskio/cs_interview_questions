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

    public GraphNode(Graph g) {
        edges = new HashSet<GraphEdge>();
        graph = g;
    }

    public void addEdge(GraphEdge e) {
        edges.add(e);
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
}
