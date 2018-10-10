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
public class recursion {
    public int fib(int n) {
        if(n<=1) {
            return 1;
        }
        else {
            return fib(n-1) + fib(n-2);
        }
    }
    
    
    public int fib_iter(int n,int arr[]) {
        if(n<=1) {
            arr[n] = 1;
            return 1;
        }
        else {
            int fib1, fib2;
            if(arr[n-1]!=0) {
                fib1 = arr[n-1];
            }
            else {
                fib1 = fib_iter(n-1, arr);
                arr[n-1] = fib1;
            }
            if(arr[n-2]!=0) {
                fib2 = arr[n-2];
            }
            else {
                fib2 = fib_iter(n-2, arr);
                arr[n-2] = fib2;
            }
            arr[n] = fib1 + fib2;
            return fib1 + fib2;
        }
    }
    
}
