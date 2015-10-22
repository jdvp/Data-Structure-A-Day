import junit.framework.TestCase;

import javax.swing.*;

/**
 * Test Cases for Binary Search Nodes
 *
 * @author JD Porterfield
 */
public class TestAbstractNode extends TestCase {


    /**
     * Simple test to see if Object searching works.
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
     * Simple test to see if Object searching works.
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
     * Simple test to see if T searching works.
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
     * Simple test to see if T searching works.
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
     * Checks whether the setParent capability of ANode works
     */
    public void testSetParent(){
        INode root = new BinarySearchNode(10);
        INode leaf = new BinarySearchNode(8);
        leaf.setParent(root);

        assertEquals(root, leaf.getParent());
    }

    /**
     * This implicitly checks the constructor of BinaryNode but is meant to ensure that getData works and returns
     * the correct value regardless of the type T.
     */
    public void testGetData(){
        String s = "WHAT";
        INode root = new BinaryNode<>(s);

        assertEquals(s, root.getData());

        Integer i = 3242;
        root = new BinaryNode<>(i);

        assertEquals(i, root.getData());

        JFrame j = new JFrame();
        root = new BinaryNode<>(j);

        assertEquals(j, root.getData());
    }
}
