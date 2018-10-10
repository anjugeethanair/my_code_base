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
public class subset_sum {
    /* Given a set of non negative numbers and a total, find if there exists a  subset in this set whose sum is same as total. */
    boolean subset_sum(int[] set,int sum) {
        boolean[][] T = new boolean[set.length][sum+1];
        
        for(int i=0;i<set.length;i++) {
            T[i][0]=true;
        }
        for(int i=0;i<set.length;i++){
            for(int j=1;j<sum+1;j++){
                if(set[i]>j){
                    if((i!=0) && (T[i-1][j])){
                        T[i][j] = true;
                        continue;
                    }
                    else{
                        T[i][j] = false;
                        continue;
                    }
                }
                else{
                    if(j==set[i]){
                        T[i][j]=true;
                    }
                    else if(i!=0 && T[i-1][j]) {
                        T[i][j] = true;
                    }
                    else if( (i!=0) && (T[i][set[i]]) && (T[i-1][j-set[i]])){
                        T[i][j]=true;
                    }
                    else{
                        T[i][j]=false;
                    }
                }
            }
        }
        for(int i=0;i<set.length;i++){
            System.out.println();
            for(int j=0;j<sum+1;j++){
                System.out.print(T[i][j]+" ");
            }
             
        }
        return T[set.length-1][sum];
    }
}
