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
public class matrix_multiply {
    /* Given some matrices, in what order you would multiply them to minimize cost of multiplication. */
    int matrix_multiply(int[] row, int[] col) {
        int k=0;
        int[][] matrix = new int[row.length][row.length];
        for(int i=0;i<row.length;i++) {
            for(int j=0;j<row.length;j++) {
                if((i+j)>=row.length) {
                    continue;
                }
                if(j== (i+j)) {
                    matrix[j][i+j] = 0;
                }
                else if ((j+1) ==(i+j)) {
                    /* length 1 */
                    matrix[j][i+j] = row[j] * col[j] * col[i+j];
                }
                else if ((j+2) ==(i+j)) {
                    /* length 1 */
                    matrix[j][i+j] = row[j] * col[j] * col[i+j];
                }
                
            }
        }


        for(int i=0;i<row.length;i++) {
            System.out.println();
            for(int j=0;j<row.length;j++) {
                System.out.print(" "+matrix[i][j]+" ");
            }
            
        }
        return 0;
    }
}
