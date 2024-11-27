package cz.educanet.graph;

import cz.educanet.commons.Pair;
import cz.educanet.queue.PriorityQueue;

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


    /**
     * Dijkstra algorithm implementation
     *
     * @param from origin label from which to begin the search
     * @param to target lebel to which we want to find the path
     *
     * @return the list of vertices visited
     */
    public List<Vertex> dijkstra(String from, String to) {
        // Priority queue that holds information about which vertex to
        // explore next, the priority is the cost from the beginning node
        // to self
        PriorityQueue<Vertex> queue = new PriorityQueue<>();

        // A Vertex -> (cost, previous) map for result lookups
        Map<Vertex, Pair<Integer, Vertex>> exploration_state = new HashMap<>();

        // Enqueue the vertex from which we want to begin
        // This is a shorthand (or rather an idiomatic way) for linear search by label
        this.vertices.stream().filter((v) -> v.getLabel().equals(from)).forEach((v) -> {
            queue.push(0, v);
            exploration_state.put(v, new Pair<>(0, null));
        });

        // Loop until all vertices discovered
        while(!queue.isEmpty()) {
            // Get next cost and vertex as a pair
            Pair<Integer, Vertex> t = queue.pop();

            // If we got the target vertex from the queue it means that we have found the shortest possible path
            if (t.second().getLabel().equals(to)) {
                // We need to reconstruct the path taken
                // t now holds the destination vertex

                // The list holding the path
                List<Vertex> path = new ArrayList<>();

                // This prints the state table at the end of the algorithm
                System.out.println("Vertex  |  Cost  |  Previous");
                // Maps each entry in the table to a string ( in format: Vertex name | cost | previous )
                exploration_state.entrySet().stream().map(k ->
                        k.getKey() + "   |   " + k.getValue().first() + "    |  " + k.getValue().second()
                ).forEach(System.out::println);

                // walk the path
                path.add(t.second());
                Vertex prev = exploration_state.get(t.second()).second();
                do {
                    path.add(prev);
                    prev = exploration_state.get(prev).second();
                } while (prev != null);

                // The corretc path is in reversed order
                return path.reversed();
            }

            // Try enqueuing all neighbours of this vertex
            for (Vertex neighbour: t.second().getNeighbours()) {
                // Cost of the path from the beginning to this `neighbour` vertex
                int newCost = t.first() + t.second().getWeights().get(neighbour);

                // If this vertex has not been yet visited, or if a shorter path has been found already
                if (!exploration_state.containsKey(neighbour) || exploration_state.get(neighbour).first() > newCost) {
                    // Set the cost for this neighbour and the previous node
                    exploration_state.put(neighbour, new Pair<>(newCost, t.second()));
                    // Enqueue this neighbour
                    queue.push(newCost, neighbour);
                }
            }
        }

        // This executes only if no path has been found
        return null;
    }
}
