package cz.educanet.graph;

import cz.educanet.queue.LIFOQueue;

import java.util.*;

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

        // Enqueue (insert) all elements from the graph
        Deque<Vertex> queue = new ArrayDeque<>(vertices.reversed());
        List<Vertex> nodes = new LinkedList<>();
        Set<Vertex> visited = new HashSet<>();

        // Until the queue is empty
        while (!queue.isEmpty()) {
            // Get next vertex to visit
            Vertex current = queue.pop();

            // If this node is in the visited set, skip it
            if (visited.contains(current)) { continue; }
            // Add it to the walk list and set it as visited
            nodes.add(current);
            visited.add(current);

            // Get all neighbours
            List<Vertex> neighbours = current.getNeighbours();
            // a shorthand for:  `for (int j = 0; j < neighbours.size(); j++)`
            for (Vertex neighbour : neighbours) {
                // And add it to the queue
                queue.push(neighbour);
            }
        }

        // Return the list
        return nodes;
    }
}
