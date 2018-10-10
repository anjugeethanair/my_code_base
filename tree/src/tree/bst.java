package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anju
 */
public class bst {
    treeNode root = null;
    
    public treeNode addToBST(int data){
        treeNode temp = new treeNode(data);
        if(root == null){
            root = temp;
            root.parent = null;            
        }
        else {
            treeNode node = root;
        
            while(node!=null){
                if(temp.data <= node.data){
                    if(node.left != null){
                        node = node.left;
                    }
                    else{
                        node.left = temp;
                        temp.parent = node;
                        break;
                    }
                }
                else {
                    if(node.right != null){
                        node = node.right;
                    }
                    else{
                        node.right = temp;
                        temp.parent = node;
                        break;
                    }
                }
            }
        }
        return temp;
    }
   
    private void _printInorder(treeNode node)
    {
        if (node == null)
            return;
 
        /* first recur on left child */
        _printInorder(node.left);
 
        /* then print the data of node */
        System.out.print(node.data+ " ");
 
        /* now recur on right child */
        _printInorder(node.right);
    }

    public void printInorder() {
        _printInorder(root);
        System.out.println();
    }
    private void _printPostorder(treeNode node)
    {
        if (node == null)
            return;
 
        /* first recur on left child */
        _printPostorder(node.left);
 
        /* now recur on right child */
        _printPostorder(node.right);

        /* then print the data of node */
        System.out.print(node.data+ " ");
    }

    public void printPostorder() {
        _printPostorder(root);
        System.out.println();
    }
    
    public void printPreOrder(){
        _printPreOrder(root);
        System.out.println();
    }
    private void _printPreOrder(treeNode node)
    {
        if (node == null)
            return;
        /* then print the data of node */
        System.out.print(node.data+ " ");
 
        /* first recur on left child */
        _printPreOrder(node.left);
 
        /* now recur on right child */
        _printPreOrder(node.right);

    }
    //Number of leaf nodes
    public int leafNodes(){
        return _leafNodes(root);
    }
    private int _leafNodes(treeNode node){
        
        if (node == null){
            return 0;
        }
        else if(node.left==null && node.right ==null){
            return 1;
        }
        else{
            return _leafNodes(node.left)+_leafNodes(node.right);
        }
    }
    public int nonleafNodes(){
        return _nonleafNodes(root);
    }
    private int _nonleafNodes(treeNode node){
        
        if (node == null){
            return 0;
        }
        else if(node.left==null && node.right ==null){
            return 0;
        }
        else{
            return _nonleafNodes(node.left)+ _nonleafNodes(node.right)+1;
        }
    }
    public int singleChildNodes(){
        return _singleChildNodes(root);
    }
    private int _singleChildNodes(treeNode node){
        
        if (node == null){
            return 0;
        }
        else if(node.left!=null && node.right==null){
            return _singleChildNodes(node.left)+1;
        }
        else if(node.right!=null && node.left==null){
            return _singleChildNodes(node.right)+1;
        }
        else{
            return _singleChildNodes(node.left) + _singleChildNodes(node.right);
        }
        
    }
    
    public int childNodes(treeNode node){
        return (_childNodes(node) -1);
    }
    private int _childNodes(treeNode node){
        if (node == null){
            return 0;
        }
        
        else{
                return _childNodes(node.left)+ _childNodes(node.right)+1;
            }
        }
    
    
    public boolean balanced(){
        return _balanced(root);
    }
    private boolean _balanced(treeNode node){
        int lcount =0,rcount =0;
        if (node == null){
           return true;
        }
        if(node.left==null && node.right ==null){
            return true;
        }
        else{
            
                lcount = _childNodes(node.left)+1;
                rcount = _childNodes(node.right)+1;
        }
        if(Math.abs(lcount-rcount)<=1){
                
                return _balanced(node.left) && _balanced(node.right);
            }
            else{
                return false;
            }
        
    }
    
    public treeNode firstCommonAncestors(treeNode node1,treeNode node2){
        return _firstCommonAncestors(root,node1,node2);
    }
    private treeNode _firstCommonAncestors(treeNode node,treeNode node1,treeNode node2){
        treeNode lnode,rnode;
        if (node == null){
           return null;
        }
        if((node.data==node1.data)||(node.data==node2.data)){
                return node;
        }
        else{
            lnode = _firstCommonAncestors(node.left,node1,node2);
            rnode = _firstCommonAncestors(node.right,node1,node2);
            if(lnode==null && rnode != null){
                return rnode;
            }
            else if(lnode!=null && rnode ==null){
                return lnode;
            }
            else if(lnode!=null && rnode!=null){
                return node;
            }
            else{
                return null;
            }
            
        }
    }
    
    //find the left-most(min value) node in a tree
    public treeNode minLeft(treeNode node){
        if (node == null){
           return null;
        }
        else if(node.left==null){
            return node;
        }
        else{
            return minLeft(node.left);
        }
    }

    public treeNode inOrderSuccessor(treeNode node){
        if (node == null){
           return null;
        }
        /*2 conditions: right node is not null, successor found in the leftmost of right subtree
        right node is null, succesoor is the left child of node
        */
        else{
            if(node.right!=null){
                node =  minLeft(node.right);
            }
            else if(node.right==null){
                while(node!=null && node.parent!=null){
                    if(node.parent.left == node){
                        return node.parent;
                    }
                    else{
                        node = node.parent;
                        
                    }
                }
            }
        }
        return node;
    }
    //inordersuccessor without prent
    public treeNode inOrderSuccessorOptimized(treeNode node,treeNode target){
        treeNode successor = root;
        if (node == null || target==null){
           return null;
        }
        /*2 conditions: right node is not null, successor found in the leftmost of right subtree
        right node is null, succesoor is the left child of node
        */
        else{
            if(node.right!=null){
                successor =  minLeft(node.right);
            }
            else {
                while(node!=target){
                    if(target.data<node.data){
                        successor = node;
                        node = node.left;
                    }
                    else{
                        node = node.right;
                    }
                }
            }
        }
            return successor;
    }
    //Level order traversal
    
    public void levelOrderTraversal(){
        _levelOrderTraversal(root);
    }
    private void _levelOrderTraversal(treeNode node){
        Queue<treeNode> q = new LinkedList<treeNode>();
        if (node == null){
           return;
        }
        q.add(node);
        while(!q.isEmpty()){
            if(node.left!=null){
                q.add(node.left);
            }
            if(node.right!=null){
                q.add(node.right);
            }
            System.out.print(q.remove().data+" ");
            node = q.peek();
        }
        return;
    }
    
    //height of a tree
    public int height(){
        return (_height(root) -1);
    }
    private int _height(treeNode node){
        int lheight =0,rheight =0;
        if(node==null){
            return 0;
        }
        else{
            //lheight = _height(node.left)+1;
            //rheight = _height(node.right)+1;
            return Math.max(_height(node.left), _height(node.right))+1;
        }
        
    }
    
    
    public boolean equals(bst tree2){
        treeNode root2 = tree2.root;
        return _equals(root,root2);
    }
    private boolean _equals(treeNode node1,treeNode node2){ 
        if(node1 == null && node2 == null) {
            return true;
        }
        if((node1 != null && node2 == null) ||(node1 == null && node2 != null)){
            return false;
        }
        else if(node1.data!= node2.data){
            return false;
        }
        
        else{
               if(_equals(node1.left,node2.left) && (_equals(node1.right,node2.right))){
                   return true;
               }
               else{
                   return false;
               }
       }        
    }
    
    public void path(treeNode target){
        _path(root,target,0);
    }
    private treeNode _path(treeNode node,treeNode target,int found){
        if (node == null || target ==null){
           return null;
        }
        
        if(node.data<target.data && found==0){
            return _path(node.right,target,0);
        }
        else if(node.data>target.data && found==0){
            return _path(node.left,target,0);
        }
        else{
            if(node.parent!= null){
                System.out.print(node.parent + " ");
                return _path(node.parent,target,1);
            }
            else{
                return null;
            }
        }
        
    }
    
    
    //path of a binary tree
    public void pathBinaryTree(treeNode target){
        treeNode retnode = _path(root,target,0);
        
        
    }
    private treeNode _pathBinaryTree(treeNode node,treeNode target,int found){
        if (node == null || target ==null){
           return null;
        }
        if(node.data == target.data){
            found = 1;
            return node;
        }
        else{
            treeNode returnnode = _pathBinaryTree(node.left,target,0);
            if(returnnode==null){
                _pathBinaryTree(node.right,target,0);
            }
            
            if(found==1){
                System.out.print(node.parent + " ");
                return _pathBinaryTree(node.parent,target,1);
            }
        }
        return node;
    }
    
    public boolean isBST(bst tree){
        return _isBST(root,Integer.MIN_VALUE ,Integer.MAX_VALUE);
    }
    private boolean _isBST(treeNode node,int min,int max){
        if (node == null){
           return true;
        }
        else{
            if(_isBST(node.left,min,node.data) && (_isBST(node.right,node.data,max))){
                return true;
            }
            else{
                return false;
            }
        
        }
    }
    
    //root to leaf sum
    public boolean rootToLeafSum(int sum){
        return _rootToLeafSum(root,sum);
    }
    private boolean _rootToLeafSum(treeNode node,int sum){
        if(node==null){
            return false;
        }
        if(node.left==null && node.right==null){
            if(node.data == sum){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            if(_rootToLeafSum(node.left,sum-node.data)|| (_rootToLeafSum(node.right,sum-node.data))){
                return true;
            }
            else{
                return false;
            }
        }
    }
    
    //root to non-leaf
    public boolean rootToNonLeafSum(int sum){
        return _rootToNonLeafSum(root,sum);
    }
    private boolean _rootToNonLeafSum(treeNode node,int sum){
        if(node==null){
            return false;
        }
        if(node.left!=null || node.right!=null){
            if(node.data == sum){
                return true;
            }
        }
        if(node.left==null && node.right==null){
            return false;
        }
        else{
            if(_rootToNonLeafSum(node.left,sum-node.data)|| (_rootToNonLeafSum(node.right,sum-node.data))){
                return true;
            }
            else{
                return false;
            }
        }
    }

    //root to given node sum
    public int rootToGivenSum(treeNode node){
        return _rootToGivenSum(root,node);
    }
    private int _rootToGivenSum(treeNode node,treeNode given){
        int sum;
        if(node==null){
            return 0;
        }
        if(node.data == given.data){
            return node.data;
        }
        else{
            sum  = _rootToGivenSum(node.left,given) + _rootToGivenSum(node.right,given);
            if(sum!=0){
                sum += node.data;
                return sum;
            }
            else{
                return 0;
            }
        }
        
    }
    
    //minimal height

    public void minimalHeightTree(int[] arr,int lo,int high){
        if(arr.length==0){
            return;
        }
        _minimalHeightTree(arr,0,high);
    }
    private treeNode _minimalHeightTree(int[] arr,int lo,int high){
        if(high <= lo) {
            return null;
        }
        int mid = (high+lo)/2;
        treeNode temp = new treeNode(arr[mid]);
        if(root == null) {
            root = temp;
        }
        temp.left  = _minimalHeightTree(arr,lo,mid);
        temp.right = _minimalHeightTree(arr,mid+1,high);
        return temp;
    }
    
    //reverse level order traversal
    public void reverseLevelOrderTraversal(){
        _reverseLevelOrderTraversal(root);
    }
    private void _reverseLevelOrderTraversal(treeNode node){
        Queue<treeNode> q = new LinkedList<treeNode>();
        Stack<treeNode> s = new Stack<treeNode>();
        if (node == null){
           return;
        }
        q.add(node);
        while(!q.isEmpty()){
            treeNode temp = q.remove();
            if(temp.left!=null){
                q.add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
            }
            s.push(temp);
        }
        while(!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }
    }
    
    
    public int floor(int given){
        return _floor(root,given);
    }
    private int _floor(treeNode node,int given){
        if(node==null){
            return -1;
        }
        else{
            if(node.data<given){
                if(node.right!=null && node.right.data<given){
                    return _floor(node.right,given);
                }
                else{
                    while(node.data>given){
                        if(node.parent!=null){
                            node = node.parent;
                        }
                        else{
                            
                            return -1;
                        }
                    }
                    return node.data;
                }
            }
            else{
                if(node.left!=null && node.left.data>given){
                    return _floor(node.left,given);
                }
                else{
                    while(node.data>given){
                        if(node.parent!=null){
                            node = node.parent;
                        }
                        else{
                            
                            return -1;
                        }
                    }
                    return node.data;
                }
                    
            }
            
        }
        
    }
    /*
if((node.left==null && node.right==null)|| (node.data==given)){
            return node.data;
        }
        if(node.data>given && node.left==null){
            return node.data;
        }
        if(node.data<given && node.right==null){
            return node.data;



    //Sum of cousin nodes of a given node in a BST
      public int sumOfCousins(treeNode given){
          return _sumOfCousins(root,given);
      }
    
      private int _sumOfCousins(treeNode node,treeNode given){
          int sum =0;
          if(node==null){
              return -1;
          }
          else if(given==node && (node.parent==null || node.parent.parent==null)){
              return -1;
          }
          else{
              if((_sumOfCousins(node.left,given)==-1) &&(_sumOfCousins(node.right,given)==-1)){
                  return -1;
              }
              else{
                  if(given==node && node.parent!=null && node.parent.parent!=null){
                    if(node.parent==node.parent.parent.left){
                    treeNode cnode = node.parent.parent.right;
                    if(cnode!=null){
                      if(cnode.left!=null){
                        sum += cnode.left.data;
                      }
                      if(cnode.right!=null){
                        sum += cnode.right.data;
                      }
                      return sum;
                  }
                  else{
                      return -1;
                  }
              }
              else if(node.parent==node.parent.parent.right){
                  treeNode cnode = node.parent.parent.left;
                  if(cnode!=null){
                      if(cnode.left!=null){
                        sum += cnode.left.data;
                      }
                      if(cnode.right!=null){
                        sum += cnode.right.data;
                      }
                      return sum;
                  }
                  else{
                      return -1;
                  }
              }
              else{
                  return -1;
              }
              }
          }
          
      }
              
      }  */    
              
              
    //find if there exist route between two nodes
    public boolean routeBetweenNodes(treeNode node1,treeNode node2){
        return _routeBetweenNodes(root,node1,node2,false,false);
    }
    private boolean _routeBetweenNodes(treeNode node,treeNode node1,treeNode node2,boolean foundnode1,boolean foundnode2){
        if(node == null) {
            return false;
        } 
        if(foundnode1 && foundnode2){
            return true;
        }
        if(node.data==node1.data){
            foundnode1 = true;
            if(foundnode2==true) {
                return true;
            }
            //return _routeBetweenNodes(node.left,node1,node2,foundnode1,foundnode2)||_routeBetweenNodes(node.right,node1,node2,foundnode1,foundnode2);
        }
        if(node.data==node2.data){
            foundnode2 = true;
            if(foundnode1==true) {
                return true;
            }
            //return _routeBetweenNodes(node.left,node1,node2,foundnode1,foundnode2)||_routeBetweenNodes(node.right,node1,node2,foundnode1,foundnode2);
        }
        //else
        {
            return _routeBetweenNodes(node.left,node1,node2,foundnode1,foundnode2)||_routeBetweenNodes(node.right,node1,node2,foundnode1,foundnode2);
        }
    }
    
    
    //iterative in order traversal
    public void i_printInorder() {
        _printInorder(root);
        System.out.println();
    }
    private void _i_printInorder(treeNode node){
        Stack<treeNode> s = new Stack<treeNode>();
        if(node==null){
            return;
        }
        //s.push(node);
        while(!s.isEmpty()){
           if(node!=null){
               s.push(node);
               node = node.left;
           }
           else{
                node = s.pop();
               System.out.print(node);
               node = node.right;
           }
        }
    }
        
    
    /*
    //binary tree
    public treeNode addToBT(int data){
        treeNode temp = new treeNode(data);
        if(root == null){
            root = temp;
            root.parent = null;            
        }
        else {
            treeNode node = root;
        
            while(node!=null){
                    if(node.left == null){
                        node = node.left;
                        temp.parent = node;
                    }
                    else if(node.right==null){
                        node.right = temp;
                        temp.parent = node;
                    }
                    else if(node.left!=null && node.right!=null){
                        node = node.left;
                    }
                    else if(node.left!=null && node.right==null){
                        node = node.right;
                }
                
            }
        }
        return temp;
    } */
    
    // non recursive post order
    // push left
    // peek go right
    // 
    
    //Stack problems
    public Stack<Integer> sortStack(Stack<Integer> s1){
        Stack<Integer> s2 = new Stack<Integer>();
        int temp = Integer.MAX_VALUE;
        int small = Integer.MAX_VALUE;
        int count = 0,size = 0,itr=0;
        while(!s1.isEmpty()){
            temp = s1.pop();
            if(small>temp){
                if(small!=Integer.MAX_VALUE) {
                    s2.push(small);
                    count++;
                }
               small = temp;
            }
            else{
                s2.push(temp);
                count++;
            }
        }
        s1.push(small);
        small = Integer.MAX_VALUE;
        size = count;
        itr = count;
        
        while(size >0){
            while(count>0){
                s1.push(s2.pop());
                count--;
            }
        
            while(itr>0){
                temp = s1.pop();
                if(small>temp){
                    if(small!=Integer.MAX_VALUE) {
                        s2.push(small);
                        count++;
                    }
                    small = temp;
                }
                else{
                    s2.push(temp);
                    count++;
                }
                itr--;
            }
            s1.push(small);
            small = Integer.MAX_VALUE;
            itr = count;
            size--;
        }
        //System.out.print(count);
        return s1;
    }
    
    public void postorderTraversal(treeNode root) {
        System.out.println("demo");
        if (root == null){ return;}
        
        Stack<treeNode> S = new Stack<>();
        
        treeNode cur = root;
        treeNode tmp;
    
        while (cur!=null || !S.isEmpty()) {
            /* Push left child to stack */
            if(cur!=null) {
                    S.push(cur);
                    cur = cur.left;
            }
            else{
                /*
                 * if there is no left child anymore, go to right
                 * child of stack top
                 */
                tmp = S.peek().right;
                /* if there is no right child, visit the node,
                if there is a right child, start exploring the right subtree*/
                if(tmp==null){
                    tmp = S.pop();
                    System.out.print(tmp.data + " ");
                    /* Pop as long as the node is the right child  of stack top, pop and visit*/
                    while(!S.isEmpty() && tmp==S.peek().right) {
                        tmp = S.pop();
                        System.out.print(tmp.data + " ");
                    }
                }
                else {
                    cur = tmp;
                }
            }
        }  
    }
       
    
    /*
    Homework - 07/23/2018 -- 95/100
    1. Number of leaf nodes            --completed
    2. Number of non leaf nodes        --completed
    3. Number of one child nodes       --completed 
    4. Number of child nodes           -- test      --completed 07/24 -- good!
    5. 4.1  balanced                   -- test      --completed 07/24 -- good!
    6. 4.7    First common ancestor      --completed           
    7. 2.1  linked list dont attempt
*/
    
    
 /*
    Homework - 07/24/2018 --     75/100
    20 1. 4.6 in order successor   --completed
    5  4. Number of child nodes    --completed 
    20 5. 4.1  balanced            --completed 

    10 3. Find the middle of a given linked list look --completed 
    10 4. Level order traversal       --completed 
    10 6. 3.6 sort stack        - have idea.
     */
    
    /*
    Homework - 07/25/2018 --     38/60
    10 0. 3.6 sort stack        -- COMPLETED!!!
    10 1. find height of tree      --completed
    11 2. check if two trees are identical  --completed
    7  3. print path from root to a specific node  --completed
    4. tower of hanoii
    */
    /*
    Homework - 07/27/2018 --     0/100
    1. path - do it binary tree (i.e, dont use bst property in ur function --completed
    2. Remove duplicates in linked list using hash set
    3. Do it without hash set
    4. tower of hanoii
    5. stack of stacks - finish pop, modify the push and pop to remove loop using count.
    6. 11.1
    7. 11.6 - hard
    8. 
    */
    /*
    1. Sum of nodes between two nodes (assume they are in same line).  -qn**
    2. root to given node sum  --completed
    3. Disscussed qns 
    4. Given a binary tree and a sum, find if there is a path from root to leaf which sums to this sum.--comp
    5. solve above question, root to non leaf . --comp
    6. attempt 4.9 after 4 n 5
    7. reverse a linked list  --comp
    8. 2.7
    9.  
    */
    
    
    /**
     * Homework 8/1
     * 1. Given a binary tree, print level order traversal in reverse direction.  https://www.youtube.com/watch?v=D2bIbWGgvzI -- completed
     * 2. Iterative in order traversal - https://www.youtube.com/watch?v=nzmtCFNae9k --completed7
     * 3. Merge two sorted linked lists and return it as a new list. --completed
            The new list should be made by splicing together the nodes of the first two lists, and should also be sorted.

            For example, given following linked lists :

                5 -> 8 -> 20 
                4 -> 11 -> 15
            The merged list should be :

            4 -> 5 -> 8 -> 11 -> 15 -> 20
     * 4. Write program to check if the braces are correct -
     *      example () (()) are correct options, (() ()) are incorrect options  --completed
     * 
     * 5. How to swap every two nodes in a linked list?   --completed
     * 6. rotate a linked list n times-  --completed
     *      definition of rotation-
     *          A -> B -> C -> D -> E -> F -> G -> H -> I -> J
     *        Rotated 2 times becomes
     *          I -> J -> A -> B -> C -> D -> E -> F -> G -> H
     * 
     * 7. Delete alternate nodes of a Linked List   --completed
     * 8. String question - do it if you are in good mood
     *      Combination of Characters in String (refer https://www.youtube.com/watch?v=xTNFs5KRV_g)
     * 9. Reverse linked list --completed
     */
    /**
     * 1. How to find all pairs on integer array whose sum is equal to given number?  Read more: https://javarevisited.blogspot.com/2015/06/top-20-array-interview-questions-and-answers.html#ixzz5N950X2oN
     * 2. Write a program to find intersection of two sorted arrays in Java?  Read more: https://javarevisited.blogspot.com/2015/06/top-20-array-interview-questions-and-answers.html#ixzz5N95IsGPL
     * 3. How to find minimum value in a rotated sorted array? Read more: https://javarevisited.blogspot.com/2015/06/top-20-array-interview-questions-and-answers.html#ixzz5N95RzOp9
     */
    
    
    /**8/6--
     * 10 1. Replace every character of string by character whose ASCII value is K times more than it https://www.geeksforgeeks.org/replace-every-character-of-string-by-character-whose-ascii-value-is-k-times-more-than-it/
     * 10 2. First non-repeating character using one traversal of string https://www.geeksforgeeks.org/first-non-repeating-character-using-one-traversal-of-string-set-2/
     * // do with char array 3. Number of Counterclockwise shifts to make a string palindrome https://www.geeksforgeeks.org/number-of-counterclockwise-shifts-to-make-a-string-palindrome/
     * 9 4. A bit confusing question - read very careful - https://www.geeksforgeeks.org/smallest-alphabet-greater-than-a-given-character/
     * 5. https://www.geeksforgeeks.org/check-strings-rotations-not-set-2/
     * 10 6. https://www.geeksforgeeks.org/check-balanced-parentheses-expression-o1-space/
     * 7. https://www.geeksforgeeks.org/program-reverse-string-iterative-recursive/
     * 8. https://www.geeksforgeeks.org/print-reverse-string-removing-vowels/
     * 9. a bit hard - https://www.geeksforgeeks.org/sorting-array-with-conditional-swapping/
     * 10. understand how ascii works - https://www.geeksforgeeks.org/convert-a-string-to-hexadecimal-ascii-values/
     * 11. ascii https://www.geeksforgeeks.org/convert-hexadecimal-value-string-ascii-value-string/
     * 12. https://www.geeksforgeeks.org/count-gfg-subsequences-given-string/
     * 13. read careful - https://www.geeksforgeeks.org/minimum-rooms-for-m-events-of-n-batches-with-given-schedule/
     * 14. read careful - https://www.geeksforgeeks.org/funny-string/
     * 
     * 
     * You must do - 1,2,3,5,6,7,8,10,11,12
     */
    /*
    1. https://www.hackerrank.com/challenges/reduced-string/problem
    2. Sum of cousin nodes of a given node in a BST

    */
}//end main
