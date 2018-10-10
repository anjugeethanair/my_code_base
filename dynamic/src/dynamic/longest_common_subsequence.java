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
public class longest_common_subsequence {
    int length_longest_common(String str1, String str2) {
        int[][] matrix = new int[str1.length()+1][str2.length()+1];
        
        for(int i=0;i<=str1.length();i++){
            if(str1==null){
                matrix[i][0]=0;
            }
        }
        for(int i=0;i<=str2.length();i++){
            if(str2==null){
                matrix[0][i]=0;
            }
        }
        for(int i=1;i<=str1.length();i++){
            for(int j=1;j<=str2.length();j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    matrix[i][j] = max(matrix[i-1][j-1]+1,matrix[i-1][j],matrix[i][j-1]);
                }
                else{
                    matrix[i][j] = max_left_top(matrix[i-1][j],matrix[i][j-1]);
                }
                
            }
        }
        return matrix[str1.length()][str2.length()];
    }
    public int max(int a,int b,int c){
        if(a>b) {
            if(a>c) {
                return a;
            }
            else {
                return c;
            }
        }
        else {
            if(b>c) {
                return b;
            }
            else {
                return c;
            }
        }
    }
    public int max_left_top(int val1,int val2){
        if(val1>=val2){
            return val1;
        }
        else{
            return val2;
        }
    }
}
