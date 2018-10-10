/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackofstacks;

import java.util.Stack;
import javax.smartcardio.Card;

/**
 *
 * @author Anju
 */
public class stackOfStacks {
    int threshold;
    int max;
    int size;
    Stack<Integer>[] stack_stacks;
    int current_stack=0;
    int number_stacks;
    
    public stackOfStacks(int threshold, int max) {
        this.threshold = threshold;
        this.max = max;
        number_stacks = max/threshold;
        stack_stacks = (Stack<Integer>[]) new Stack[number_stacks];
        current_stack = 0;
        //for(int i=0;i<number_stacks;i++) {
            stack_stacks[current_stack] = new Stack<Integer>();
        //}
        
        size =0;
    }
    
    public void push(int data) {
        size++;
        /** check if stack i has space */
        if(size <= threshold) {
            stack_stacks[current_stack].push(data);
        }
        if(size==threshold){
            size=0;
            current_stack++;
            stack_stacks[current_stack] = new Stack<Integer>();
        }
    }


    public int pop() {
        int i;
        for(i=number_stacks-1;i>=0;i--) {
            // check if stack i has space 
            if(stack_stacks[i].size() <= threshold && (stack_stacks[i].size()!=0)) {
                return stack_stacks[i].pop();
                
            }
        }
        return Integer.MAX_VALUE;
    } 
}
    /*
    public void push_no_loop(int data) {
        if(stack_stacks[current_stack].size() >= threshold) {
            current_stack++;
        }
        stack_stacks[current_stack].push(data);
    }
    
}*/
