import junit.framework.TestCase;

/**
 * Test Cases for Binary Search Nodes
 *
 * @author JD Porterfield
 */
public class TestBinarySearchTree extends TestCase {

    /**
     * Simple test to see if insertion works on binary search trees
     */
    public void testInsert(){
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
    public void testInsertNonInt(){
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
     * Simple test to see if Object searching works on binary search trees.
     * This is for a positive case.
     */
    public void testObjectCheckForTrue(){
        INode root = new BinarySearchNode(5);
        INode findNode = new BinarySearchNode(8);
        root.insert(new BinarySearchNode(3));
        root.insert(findNode);
        root.insert(new BinarySearchNode(4));

        boolean answer = true;
        boolean res = root.checkFor(findNode);

        assertEquals(answer, res);
    }

    /**
     * Simple test to see if Object searching works on binary search trees.
     * This is for a negative case.
     */
    public void testObjectCheckForFalse(){
        INode root = new BinarySearchNode(5);
        INode findNode = new BinarySearchNode(9);
        root.insert(new BinarySearchNode(3));
        root.insert(new BinarySearchNode(8));
        root.insert(new BinarySearchNode(4));

        boolean answer = false;
        boolean res = root.checkFor(findNode);

        assertEquals(answer, res);
    }

    /**
     * Simple test to see if Integer searching works on binary search trees.
     * This is for a positive case.
     */
    public void testIntCheckForTrue(){
        INode root = new BinarySearchNode(5);
        root.insert(new BinarySearchNode(3));
        root.insert(new BinarySearchNode(8));
        root.insert(new BinarySearchNode(4));

        boolean answer = true;
        boolean res = root.checkFor(8);

        assertEquals(answer, res);
    }

    /**
     * Simple test to see if Integer searching works on binary search trees.
     * This is for a negative case.
     */
    public void testIntCheckForFalse(){
        INode root = new BinarySearchNode(5);
        root.insert(new BinarySearchNode(3));
        root.insert(new BinarySearchNode(8));
        root.insert(new BinarySearchNode(4));

        boolean answer = false;
        boolean res = root.checkFor(137);

        assertEquals(answer, res);
    }

    /**
     * Simple test to see if deletion works on binary search trees.
     * This is for the right leaf
     */
    public void testDeleteRightLeaf(){
        INode root = new BinarySearchNode(5);
        root.insert(new BinarySearchNode(3));
        INode leaf = new BinarySearchNode(8);
        root.insert(leaf);
        root.insert(new BinarySearchNode(4));

        root.delete(leaf);

        String answer = "5[3[,4[,]],]";
        String res = root.toString();

        assertEquals(answer, res);
    }

    /**
     * Simple test to see if deletion works on binary search trees.
     * This is for the right leaf
     */
    public void testDeleteLeftLeaf(){
        INode root = new BinarySearchNode(5);
        root.insert(new BinarySearchNode(3));
        INode leaf = new BinarySearchNode(2);
        root.insert(new BinarySearchNode(8));
        root.insert(new BinarySearchNode(4));
        root.insert(leaf);

        root.delete(leaf);

        String answer = "5[3[,4[,]],8[,]]";
        String res = root.toString();

        assertEquals(answer, res);
    }

    /**
     * Tests the deletion of an inner node with only one child. In this case, the node ~should~ be replaced by its child.
     */
    public void testDeleteInnerNodeWithOneChild(){
        INode root = new BinarySearchNode(15);
        root.insert(new BinarySearchNode(5));
        INode deleteMe = new BinarySearchNode(20);
        root.insert(deleteMe);
        root.insert(new BinarySearchNode(4));
        root.insert(new BinarySearchNode(6));
        root.insert(new BinarySearchNode(22));
        root.insert(new BinarySearchNode(21));
        root.insert(new BinarySearchNode(24));


        root.delete(deleteMe);

        String answer = "15[5[4[,],6[,]],22[21[,],24[,]]]";
        String res = root.toString();

        assertEquals(answer, res);
    }

    /**
     * Tests the deletion of an inner node with two children. In this case, the node ~should` be replaced by the lowest
     * value in its right subtree.
     */
    public void testDeleteInnerNodeWithBothChildren(){
        INode root = new BinarySearchNode(5);
        root.insert(new BinarySearchNode(2));
        INode deleteMe = new BinarySearchNode(12);
        root.insert(deleteMe);
        root.insert(new BinarySearchNode(-4));
        root.insert(new BinarySearchNode(3));
        root.insert(new BinarySearchNode(9));
        root.insert(new BinarySearchNode(21));
        root.insert(new BinarySearchNode(19));
        root.insert(new BinarySearchNode(25));

        root.delete(deleteMe);

        String answer = "5[2[-4[,],3[,]],19[9[,],21[,25[,]]]]";
        String res = root.toString();

        assertEquals(answer, res);
    }

    /**
     * Tests the deletion of the root if it has two children
     */
    public void testDeleteRootWithTwoChildren(){
        INode root = new BinarySearchNode(5);
        root.insert(new BinarySearchNode(4));
        root.insert(new BinarySearchNode(6));

        root.delete(root);

        String answer = "6[4[,],]";
        String res = root.toString();

        assertEquals(answer, res);
    }

    /**
     * Tests the deletion of the root if it has two children
     */
    public void testDeleteRootWithOneChild(){
        INode root = new BinarySearchNode(5);
        root.insert(new BinarySearchNode(4));

        root.delete(root);

        String answer = "4[,]";
        String res = root.toString();

        assertEquals(answer, res);
    }
}
