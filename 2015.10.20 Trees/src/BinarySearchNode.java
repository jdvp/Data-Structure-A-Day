/**
 * Created by JD on 10/20/2015.
 */
public class BinarySearchNode extends ANode<Integer> {

    private static final int LEFT = 0;
    private static final int RIGHT = 1;

    public BinarySearchNode (int  dataIn){
        data = dataIn;
        n = 2;
        children = new INode[n];
    }

    @Override
    public void insert(INode node){
        if(! (node.getData() instanceof Integer )) {
            System.err.println("BST requires Integer Data for Input Nodes.");
            return;
        }

        node.setParent(this);

        if((Integer) node.getData() < this.getData()){
            if(children[LEFT] == null)
                children[LEFT] = node;
            else
                children[LEFT].insert(node);
        } else {
            if(children[RIGHT] == null)
                children[RIGHT] = node;
            else
                children[RIGHT].insert(node);
        }
    }

    @Override
    public void delete(INode node) {
        if(this.equals(node)){
            if(children[LEFT] == null && children[RIGHT] == null)
                parent.replaceChild(this, null);

            else if(children[LEFT] == null)
                parent.replaceChild(this, children[RIGHT]);

            else if(children[RIGHT] == null)
                parent.replaceChild(this, children[LEFT]);

            else{
                BinarySearchNode successor = ((BinarySearchNode) children[RIGHT]).findMin();
                data = successor.getData();
                children[RIGHT].delete(successor);
            }
        }
        else if((Integer) node.getData() < data)
            children[LEFT].delete(node);
        else
            children[RIGHT].delete(node);
    }


    /**
     * Finds the minimum-valued node in a subtree
     * @return
     */
    private BinarySearchNode findMin(){
        BinarySearchNode min = this;
        while(min.getChildren()[LEFT] != null)
            min = (BinarySearchNode) min.getChildren()[LEFT];

        return min;
    }
}
