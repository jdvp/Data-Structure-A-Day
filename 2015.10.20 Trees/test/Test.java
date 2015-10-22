import junit.framework.TestCase;

/**
 * Created by JD on 10/20/2015.
 */
public class Test extends TestCase {

    /**
     * Simple test to see if insertion works on binary search trees
     */
    public void testBinarySearchInsert(){
        INode root = new BinarySearchNode(5);
        root.insert(new BinarySearchNode(3));
        root.insert(new BinarySearchNode(8));
        root.insert(new BinarySearchNode(4));

        String answer = "5[3[,4[,]],8[,]]";
        String res = root.toString();

        assertEquals(answer, res);
    }


    /**
     * Simple test to see if insertion works on binary search trees
     */
    public void testBinarySearchInsertNonInt(){
        INode root = new BinarySearchNode(5);
        root.insert(new BinarySearchNode(3));
        root.insert(new BinaryNode<>("WHAT"));
        root.insert(new BinarySearchNode(8));
        root.insert(new BinaryNode<>("WILL THIS WORK"));
        root.insert(new BinarySearchNode(4));
        root.insert(new BinaryNode<>("I HOPE SO"));

        String answer = "5[3[,4[,]],8[,]]";
        String res = root.toString();

        assertEquals(answer, res);
    }
    /**
     * Simple check to see if Insert works for BinaryTrees created with BinaryNodes correctly.
     */
    public void testStringBinaryTreeInsert(){
        INode root = new BinaryNode<>("a");
        root.insert(new BinaryNode<>("b"));
        root.insert(new BinaryNode<>("c"));
        root.insert(new BinaryNode<>("d"));
        root.insert(new BinaryNode<>("e"));
        root.insert(new BinaryNode<>("f"));

        String answer = "a[b[d[f[,],],e[,]],c[,]]";
        String res = root.toString();

        assertEquals(answer, res);

    }


}
