/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

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
        int[] arr1 = {2,4,6,8,5};
        arrays obj1  = new arrays(arr1);
        int[][] arr2 = {{2,4,6,8},{11,12,13,14},{16,17,18,19},{25,26,27,28}};
        arrays obj2  = new arrays(arr2);
        
        System.out.println("search found in index "+ obj1.binarySearch(0, arr1.length-1, 10));
        int[] index = obj2.matbinarySearch(0, (arr2.length*arr2.length)-1, 11,arr2.length);
        System.out.println("search found in row "+index[0]+" col "+index[1]);
        System.out.println(obj1.setUnset(0));
        System.out.println(obj1.kValue(arr1,2));
    }  
}
