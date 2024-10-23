package cz.educanet.graph;

import cz.educanet.queue.LIFOQueue;

import java.util.LinkedList;
import java.util.List;

/**
 * Graph
 * A structure describing a graph. The underlying
 * structure is a list of nodes with linked neighbours.
 *
 * Each vertex in the graph has a collection (list) of all
 * other vertices it has a connection (edge) with
 */
public class Graph {
    // A list of all the vertices in the graph
    private final List<Vertex> vertices;

    // The name of this graph
    private final String name;

    /**
     * Construct a new instance of a graph
     * @param name the name of the graph
     */
    public Graph(String name) {
        vertices = new LinkedList<>();
        this.name = name;
    }

    /**
     * Add a new node/vertex to the graph
     * @param v the node to insert
     */
    public void addVertex(Vertex v) {
        vertices.add(v);
    }

    /**
     * Traverses the graph by DFS and returns the
     * vertices in the order they were visited in
     *
     * @return list of vertices
     */
    public List<Vertex> depthFirstSearch() {
        // LIFO queue used to implement the DFS
        LIFOQueue<Vertex> queue = new LIFOQueue<>();

        // Enqueue (insert) the first element from
        // where the DFS begins
        queue.enqueue(vertices.getFirst());

        // Until the queue is empty
        while (!queue.isEmpty()) {
            // Get next vertex to visit
            Vertex current = queue.dequeue();
            // Print its name
            System.out.println("Jsem " + current);

            // Get all neighbours
            List<Vertex> neighbours = current.getNeighbours();
            // a shorthand for:  `for (int j = 0; j < neighbours.size(); j++)`
            for (Vertex neighbour : neighbours) {
                // And print their name
                System.out.println("  > a mám souseda " + neighbour);
            }
        }

        // Return the list
        return null;
    }
}
