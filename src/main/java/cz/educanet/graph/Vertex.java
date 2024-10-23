package cz.educanet.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * A structure describing a node/vertex in a graph.
 * This graph implicitly has to be directed.
 */
public class Vertex {
    // Name of this vertex
    private final String label;

    // List of neighbouring vertices
    private final List<Vertex> neighbors;

    /**
     * Construct new vertex with given label
     * @param label name of the node
     */
    public Vertex(String label) {
        this.label = label;
        this.neighbors = new ArrayList<>();
    }

    /**
     * @param other the other vertex we want to connect
     *
     * Define a new neighbour of this vertex
     */
    public void addNeighbour(Vertex other) {
        this.neighbors.add(other);
    }

    /**
     * @return all neighbouring vertices as a collection
     */
    public List<Vertex> getNeighbours() {
        return neighbors;
    }

    /**
     * Getter for the label property
     */
    public String getLabel() {
        return label;
    }

    // Override toString to return the name with #of neighbours
    @Override
    public String toString() {
        return label + " (" + neighbors.size() + ")";
    }

    // We'd like to be able to compare two nodes via == operator
    // In theory the labels are not guaranteed to be unique, but it
    // is reasonable to assume so
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Vertex && ((Vertex) obj).label.equals(this.label);
    }

    // We SHOULD override hashCode when overriding equals, as
    // the methods are tightly connected
    // Look at hashCode and equals usage in HashMaps, HashSets and similar
    @Override
    public int hashCode() {
        return label.hashCode();
    }

}
