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
public class knapsack {
    public int knapsact(int[] val, int[] wt,int n) {
        
        int[][] T = new int[val.length][n+1];
        for(int i=0;i<val.length;i++) {
            T[i][0] = 0; 
        }
        for(int j=0;j<=n;j++) {
            //TODO
            if(wt[0]>j){
                T[0][j] = 0;
            }
            else{
                T[0][j] = val[0];
            }
        }
       
                
        for(int i=1;i<val.length;i++){
            for(int j=0;j<=n;j++){
                 if(wt[i]>j){
                     T[i][j] = T[i-1][j];
                 }
                 else{
                     
                     T[i][j] = max(val[i]+T[i-1][j-wt[i]],T[i-1][j]);
                 }
            }
        }
       
        
        for(int i=0;i<val.length;i++){
            System.out.println();
            for(int j=0;j<=n;j++){
                System.out.print(" " + T[i][j] + " ");
            }
        }
        return T[val.length-1][n];
    }
    
    public int max(int val1,int val2){
        if(val1>=val2){
            return val1;
        }
        else{
            return val2;
        }
    }
    
}
