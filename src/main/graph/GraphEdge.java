package graph;

/**
 * Edge in a Graph that connects 2 GraphNodes
 *
 * @author Chris Arriola
 */
public class GraphEdge {

    Graph graph;
    GraphNode from;
    GraphNode to;

    public GraphEdge(Graph g, GraphNode from, GraphNode to) {
        this.graph = g;
        this.from = from;
        this.to = to;
    }

    public void addEdgeToNodes() {
        from.addEdge(this);
        to.addEdge(this);
    }

    public Graph getGraph() {
        return graph;
    }
}
