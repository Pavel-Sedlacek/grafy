package cz.educanet.graph.tree;

import cz.educanet.commons.Pair;

/**
 * Generic binary tree
 * @param <T> generic over node data
 * @param <W> generic over edge weight, has to implement [Comparable] with self
 */
public class LinkedBinaryTree<T, W extends Comparable<? super W>>
        implements Tree<T,  LinkedBinaryTree.BinaryTreeNode<T, W>> {

    /**
     * Inner data class for storing information about a vertex
     *
     * @param <T> generic over node data
     * @param <W> generic over edge weight
     */
    public record BinaryTreeNode<T, W>(
            // Data in this vertex
            T data,
            // Reference to the parent node
            BinaryTreeNode<T, W> parent,
            // Reference to the left child
            Pair<BinaryTreeNode<T, W>, W> left,
            // Reference to the right child
            Pair<BinaryTreeNode<T, W>, W> right
    ) {

        /**
         * Recursive DFS search in
         * @param nodeData the data we are searching for
         * @return the found node or null otherwise
         */
        public BinaryTreeNode<T, W> searchSubtree(T nodeData) {
            // If this node is the one we are looking for, return it
            if (this.data.equals(nodeData))
                return this;

            // search left subtree, if it returned something not null, it found
            // the node so return it and stop the search
            BinaryTreeNode<T, W> left = left().first().searchSubtree(nodeData);
            if (left != null)
                return left;
            // otherwise return the right subtree result
            return this.right().first().searchSubtree(nodeData);
        }
    }

    // root of this tree
    private final BinaryTreeNode<T, W> root;

    /**
     * Construct a new binary tree
     * @param root of the tree
     */
    public LinkedBinaryTree(BinaryTreeNode<T, W> root) {
        this.root = root;
    }

    @Override
    public BinaryTreeNode<T, W> getRoot() {
        return root;
    }

    @Override
    public BinaryTreeNode<T, W> findNode(T nodeData) {
        // Recursive DFS search
        return root.searchSubtree(nodeData);
    }

    @Override
    public boolean isCanonicalTree() {
        // TODO implement
        return false;
    }
}
