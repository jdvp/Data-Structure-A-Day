/**
 * Created by JD on 10/20/2015.
 */
public class BinaryNode<T> extends ANode<T> {

    private static final int LEFT = 0;
    private static final int RIGHT = 1;

    public BinaryNode (T  dataIn){
        data = dataIn;
        n = 2;
        children = new INode[n];
    }

    /**
     * Binary Trees just add the item to one of their children and if their immediate children aren't free, inserts at the
     * left child.
     * @param node The node to insert
     */
    @Override
    public void insert(INode node){
        parent = this;
        if(children[LEFT] == null)
            children[LEFT] = node;
        else if(children[RIGHT] == null)
            children[RIGHT] = node;
        else
            children[LEFT].insert(node);
    }

    @Override
    public void delete(INode node) {

    }
}
