package cz.educanet.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A structure describing a node/vertex in a graph.
 * This graph implicitly has to be directed.
 */
public class Vertex {
    // Name of this vertex
    private final String label;

    // List of neighbouring vertices
    private final List<Vertex> neighbors;
    private final Map<Vertex, Integer> weights;

    /**
     * Construct new vertex with given label
     * @param label name of the node
     */
    public Vertex(String label) {
        this.label = label;
        this.neighbors = new ArrayList<>();
        this.weights = new HashMap<>();
    }

    /**
     *
     * @param other
     * @param weight
     */
    public void addNeighbour(Vertex other,int weight) {
        this.neighbors.add(other);
        this.weights.put(other, weight);
    }

    /**
     * @return all neighbouring vertices as a collection
     */
    public List<Vertex> getNeighbours() {
        return neighbors;
    }

    /**
     * @return all neighbouring vertices weights
     */
    public Map<Vertex, Integer> getWeights() {
        return weights;
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
