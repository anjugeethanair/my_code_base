package bitmanipulation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anju
 */
public class bitManipulation {
    public int replaceDigits( int a,  int b, int i, int j) {
        /*
        int mask = (1<<(j-i+1))-1;
        mask = mask <<i;
        mask = mask & a;
        mask>>=i;
        System.out.println("mask " + mask );*/
        return (a & ((1<<(j-i+1)) -1)<<i)>>i;    
}
    
}
