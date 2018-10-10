/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamic;
boolean wontattack(int i1, int j1, int i2, int j2);
/**
 *
 * @author Anju
 */
public class nqueens {
    boolean nqueens(int[] queenpos) {
       return findpositionforcol(0,queenpos);
    }
    
    boolean findpositionforcol(int levelofrecur,int[] queenpos){
        for(int col=0;col<queenpos.length;col++){
            //attack true-attacked, false-not attacked
            if(!attack(levelofrecur,col,queenpos)){
                queenpos[levelofrecur] = col;
                if(findpositionforcol(levelofrecur+1,queenpos)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    boolean attack(int levelofrecur,int col,int[] queenpos){
        return true;
    }
    
}
