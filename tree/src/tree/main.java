/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

import java.util.Stack;

/**
 *
 * @author Anju
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hello World1");
        
        bst tree = new bst();
        bst tree2 = new bst();
        
        treeNode val4 = tree.addToBST(30);
        tree.addToBST(50);
        tree.addToBST(60);
        treeNode val1 = tree.addToBST(40);
        
        
        
        
        tree.addToBST(30);
        tree.addToBST(20);
        treeNode val2 =tree.addToBST(25);
        tree.addToBST(26);
        tree.addToBST(10);
        
        
        tree2.addToBST(30);
        tree2.addToBST(50);
        tree2.addToBST(40);
        tree2.addToBST(30);
        tree2.addToBST(20);
        treeNode val3 = tree2.addToBST(25);
        tree2.addToBST(26);
        tree2.addToBST(10);
        /*
         //test cases for equals 
         
        treeNode val7 = tree2.addToBST(80);
        tree2.addToBST(70);
        tree2.addToBST(30);
        tree2.addToBST(79);
        tree2.addToBST(71);
        tree2.addToBST(78);
        tree2.addToBST(72);
        tree2.addToBST(73);
        
        tree.addToBST(80);
        tree.addToBST(70);
        tree.addToBST(30);
        tree.addToBST(79);
        tree.addToBST(71);
        tree.addToBST(78);
        tree.addToBST(72);
        tree.addToBST(73);
        */
        
        /*
        //test cases for in order successor 
        tree.addToBST(70);
        tree.addToBST(100);
        tree.addToBST(80);
        tree.addToBST(81);
        tree.addToBST(82);
        treeNode val3 = tree.addToBST(83); 
        */

        tree.printInorder();
        tree.printPostorder();
        tree.printPreOrder();
        
        System.out.println("No: of leaf nodes " + tree.leafNodes());
        System.out.println("No: of nonleaf nodes " + tree.nonleafNodes());
        System.out.println("No: of singlechild nodes " + tree.singleChildNodes());
        System.out.println("No: of child nodes " + tree.childNodes(val4));
        System.out.println("Balanced ? "+ tree.balanced());
        System.out.println("first common ancestors " + tree.firstCommonAncestors(val1, val2));
        System.out.println("in order successor " + tree2.inOrderSuccessor(val3));
        tree.levelOrderTraversal();
        System.out.println();
        System.out.println("height of tree "+ tree.height());
        System.out.println("tree equals? "+ tree.equals(tree2));
        tree2.path(val3);
        System.out.println();
        
        
        tree.pathBinaryTree(val2);
        System.out.println();
        System.out.println(tree.rootToLeafSum(131));
        System.out.println(tree.rootToNonLeafSum(60));
        
        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        bst treenew = new bst();
        //treenew.minimalHeightTree(arr, 0, 9);
        //treenew.printInorder();
        tree.reverseLevelOrderTraversal();
        System.out.println();
        System.out.println("iteratie in order traversal");
        tree.i_printInorder();
        System.out.println();
        System.out.println(tree.rootToGivenSum(val2));
        
        System.out.println("ROUTE BW 2 NODES");
        //treeNode valn = new treeNode(5);
        System.out.println(tree.routeBetweenNodes(val2,val4));
        
        System.out.println(tree2.floor(24));
        /****** Stack problems *****
        Stack<Integer> s1 = new Stack<Integer>();
        s1.push(2);
        s1.push(1);
        s1.push(2);
        s1.push(12);
        s1.push(20);
        s1.push(0);
        s1.push(10);
        Stack<Integer> s2 = tree.sortStack(s1);
        while(!s2.isEmpty()){
            System.out.print(s2.pop()+" ");
        }
        
        */
    }
    public static int multiply(int a, int b) {
        return a*b;
    }
    
}
