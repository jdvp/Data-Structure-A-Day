/**
 * Node interface.
 * Will support all types of trees (eventually), e.g. binary/n-ary, balancing/non-balancing, etc.
 *
 * @author JD Porterfield
 */
public interface INode<T> {
    INode[] getChildren();

    /**
     * Inserts a node into the tree.
     * The specific implementation depends on the type of node (and therefore the type of tree).
     * @param node The node to insert
     */
    void insert(INode node);

    /**
     * Checks for a node in the tree, this is object wise meaning that the search will only be true if the actual object
     * that has been inserted into the tree is searched for.
     * @param node The node to search for
     * @return true if the node is in the tree
     */
    boolean checkFor(INode node);

    /**
     * Checks for a node in the tree based on whether or not there is a node that contains the same data.
     * @param data The data to search for
     * @return true if the data is in the tree
     */
    boolean checkFor(T data);

    /**
     * Deletes a specific node from the tree
     * @param node the node to delete
     */
    void delete(INode node);

    /**
     * Gets the data from this node instance
     * @return data from this node
     */
    T getData();

    /**
     * Prints the method in a human friendly way.
     * Prints the tree in like so (assuming we start at the root):
     * {data}
     * {child1 data} {child2 data}
     * {grandchild1 data} {gc2 data} {gc3 data} {gc4 data}
     */
    void printTree();

    /**
     * Returns a string representation of the tree that could be parsed later to recreate the tree.
     */
    @Override
    String toString();

    /**
     * Replaces one of this node's children with the specified node
     * @param child the node to replace
     * @param replacement the replacement node
     */
    void replaceChild(INode child, INode replacement);

    /**
     * Sets the parent of the current node
     * @param parent The parent of this node
     */
    void setParent(INode parent);

    /**
     * Gets the parent of the current node
     */
    INode getParent();
}
