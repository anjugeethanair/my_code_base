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
public class minimunCost {
    public int minimumCostPath(int[][] matrix) {
        
        int[][] T = new int[matrix.length][matrix[0].length];
        T[0][0] = matrix[0][0];
        for(int i=1;i<matrix[0].length;i++){
            T[0][i] = matrix[0][i-1]+matrix[0][i];
        }
        for(int i=1;i<matrix.length;i++){
            T[i][0] = matrix[i-1][0]+matrix[i][0];
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                T[i][j] = matrix[i][j] + min(matrix[i][j-1],matrix[i-1][j]);
            }
        }
        return T[matrix.length-1][matrix[0].length-1];
    }
    
    public int min(int a, int b){
        if(a<b){
            return a;
        }
        else{
            return b;
        }
    }
}

//5:35-