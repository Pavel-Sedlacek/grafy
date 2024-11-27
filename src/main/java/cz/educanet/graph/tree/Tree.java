package cz.educanet.graph.tree;

/**
 * A generic tree interface
 * @param <T> generic over vertex data
 * @param <N> generic over edge weight
 */
public interface Tree<T, N> {

    /**
     * Retrieve the root of the tree
     * @return the root
     */
    N getRoot();

    /**
     * Find the node in the tree that has nodeData
     *
     * @param nodeData the data to search for
     * @return the underlying node
     */
    N findNode(T nodeData);

    /**
     * Checks whether the structure is a tree as per definition.
     * Note that a tree has to have:
     * <ul>
     *     <li> only one component and |V| - |E| = 1 </li>
     *     <li> only one component and there are no cycles (loops) </li>
     *     <li> no cycles (loops) and |V| - |E| = 1 </li>
     *     <li> each vertex has one and only one parent </li>
     *     <li> ... </li>
     * </ul>
     * @return whether it is tree as per definition or not
     */
    boolean isCanonicalTree();
}
