/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamic;

/**
 *
 * @author Anju
 */
public class subset_set {
    void subsets(int [] array) {
        int[] subset = new int[array.length];
        helper(array, subset, 0);
    }
    void helper(int[] array, int[] subset, int i) {
        if(i==(array.length)) {
            for(int j=0;j<array.length;j++) {
                System.out.print(" " + subset[j]);
            }
            System.out.println();
        }
        else {
            subset[i] = 0;
            helper(array, subset, i+1);
            subset[i] = array[i];
            helper(array, subset, i+1);
        }
    }
    
}
