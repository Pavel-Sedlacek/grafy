package cz.educanet.graph.tree;

import java.util.ArrayList;
import java.util.List;

public class ArrayBinaryTree<T, W extends Comparable<? super W>>
        implements Tree<T, ArrayBinaryTree.BinaryTreeNode<T, W>> {

    /**
     * A simple wrapper for nodes
     * @param <T>
     * @param <W>
     */
    public record BinaryTreeNode<T, W>(
            // the data in the node
            T nodeData,
            // Here we store the weight in the `target` node
            W weightFromParent
    ) {}

    // The array storing the nodes
    // We'd prefer a continuous homogeneous array for cache locality
    private final List<BinaryTreeNode<T, W>> raw = new ArrayList<>();

    /**
     * Adds this node to the last empty space
     * @param node to add
     */
    public void appendNode(BinaryTreeNode<T, W> node) {
        raw.add(node);
    }

    @Override
    public BinaryTreeNode<T, W> getRoot() {
        return raw.getFirst();
    }

    @Override
    public BinaryTreeNode<T, W> findNode(T nodeData) {
        // BFS linear search in the tree
        for (BinaryTreeNode<T, W> node : raw)
            if (node.nodeData.equals(nodeData))
                return node;
        return null;
    }

    @Override
    public boolean isCanonicalTree() {
        // The array representation is always a valid tree
        // BUT IT MAY NOT BE WHAT WE INTENDED
        return true;
    }
}
