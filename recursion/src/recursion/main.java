/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

/**
 *
 * @author Anju
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        recursion recursion_p1 = new recursion();
        // TODO code application logic here
        int arr[] = new int[11];
        System.out.println("dfsd "+recursion_p1.fib_iter(10, arr));
        for(int i=0;i<9;i++) {
            System.out.println(arr[i]);
        }
        
    }
    
}
