/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

import java.util.Stack;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anju
 */
public class TreeTest {
    
    public TreeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

 /*
    /**
     * Test of multiply method, of class main.
     */
    @Test
    public void testmultiply() {
        assertEquals(main.multiply(10, 10), 100);
        
    }
    /**
     * Test of common ancestor
     *//*
    @Test
    public void testfirstCommonAncestors() {
        bst tree = new bst();
        tree.addToBST(30);
        treeNode val1 = tree.addToBST(50);
        treeNode val2 =  tree.addToBST(40);
        tree.addToBST(30);
        tree.addToBST(20);
        tree.addToBST(25);
        tree.addToBST(10);

        treeNode ancest = tree.firstCommonAncestors(val1, val2);
        assertEquals(ancest.data, 50);
        
    }*/
    /**
     * Test of levelOrder
     *//*
    @Test
    public void testLevelOrder() {
        bst tree = new bst();
        tree.addToBST(30);
        treeNode val1 = tree.addToBST(50);
        treeNode val2 =  tree.addToBST(40);
        tree.addToBST(30);
        tree.addToBST(20);
        tree.addToBST(25);
        tree.addToBST(10);
        tree.levelOrderTraversal();
    }*/
    /**
     * Test of levelOrder
     */
    /*
    @Test
    public void testsortStack() {
        Stack<Integer> s1 = new Stack<Integer>();
        bst tree = new bst();
        s1.push(4);
        s1.push(7);
        s1.push(5);
        s1.push(2);
        s1.push(9);
        s1.push(1);
        Stack<Integer> s2 = tree.sortStack(s1);
        //assertEquals(s2.pop(), 9);
        //assertEquals(s2.pop(), 9);
        while(!s2.isEmpty()){
            System.out.print(s2.pop()+" ");
        }
    }
    @Test
    public void testroutebw2node() {
        bst tree = new bst();
        tree.addToBST(30);
        treeNode valn = new treeNode(20);
        treeNode val1 = tree.addToBST(50);
        treeNode val2 =  tree.addToBST(40);
        tree.addToBST(30);
        tree.addToBST(20);
        tree.addToBST(25);
        tree.addToBST(10);
        boolean output = tree.routeBetweenNodes(val1,val2);
        assertEquals(output, true);
        output = tree.routeBetweenNodes(val1,valn);
        assertEquals(output, false);
    }
    */
    
    /*
            30
        20      50
     10   25 40
    */
    
    @Test
    public void testpostorderTraversal() {
        bst tree = new bst();
        treeNode root = tree.addToBST(30);
        tree.addToBST(50);
        tree.addToBST(40);
        tree.addToBST(20);
        tree.addToBST(25);
        tree.addToBST(10);
        System.out.println("post order");
        tree.postorderTraversal(root);
        System.out.println();
        System.out.println("post order done");
        //assertEquals(ancest.data, 50);
    }
}
