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
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] val = {1,4,5,7};
        int[] wt  = {1, 3, 4, 5};
        knapsack kn = new knapsack();
        System.out.println("Max value " + kn.knapsact(val, wt,7));
        int[] array = {1,2};
        subset_set subset = new subset_set();
        System.out.println("Subsets - " );
        subset.subsets(array);
        longest_common_subsequence subs = new longest_common_subsequence();
        System.out.println(subs.length_longest_common("abcdaf", "acbcf"));
        matrix_multiply mat_mult = new matrix_multiply();
        int[] row={2,3,6,4};
        int[] col={3,6,4,5};
        mat_mult.matrix_multiply(row, col);
        subset_sum subset_sum = new subset_sum();
        int[] set = {2,3,7,8,10};
        subset_sum.subset_sum(set, 11);
        
        System.out.println(detectCapitalUse("USA"));
        int[][] mincost = {{1,3,5,8},{4,2,1,7},{4,3,2,3}};
        minimunCost mc = new minimunCost();
        System.out.println(mc.minimumCostPath(mincost));    
        
    }

/*
HOMEWORK - 8/13
1. dynamic https://www.youtube.com/watch?annotation_id=annotation_2195265949&feature=iv&src_vid=Y0ZqKpToTic&v=NJuKJ8sasGk
2. https://leetcode.com/problems/roman-to-integer/description/ . --completed
3. slightly hard - https://leetcode.com/problems/count-and-say/description/ . --completed
4. https://leetcode.com/problems/valid-palindrome/description/ --completed
5. https://leetcode.com/problems/detect-capital/description/ . --completed
6. https://leetcode.com/problems/unique-morse-code-words/description/ . 

*/


    public int romanToInt(String s) {
        int tens;
        int units;
        int sum=0;
        int flag=0;
        for(int i=0;i<s.length();i++){
            //for 4 and 9, 40 and 90, for 400 and 900
            if(s.charAt(i)=='I'){
                if((i+1 != s.length()) && (s.charAt(i+1)=='V' || s.charAt(i+1)=='X')){
                    flag=1;
                }
                else{
                    flag=0;
                }
                
            }
            else if(s.charAt(i)=='C'){
                if((i+1 != s.length()) && (s.charAt(i+1)=='D' || s.charAt(i+1)=='M')){
                    flag=1;
                }
                else{
                    flag=0;
                }
                
            }
            else if(s.charAt(i)=='X'){
                if((i+1 != s.length()) && (s.charAt(i+1)=='L' || s.charAt(i+1)=='C')){
                    flag=1;
                }
                else{
                    flag=0;
                }
                
            }
            else{
                    flag=0;
            }
            
            if(flag==1){
                tens = convert(s.charAt(i+1));
                units = convert(s.charAt(i));
                i++;
                sum += tens - units; 
            }
            else{
                sum += convert(s.charAt(i));
            }
            
        }
         return sum;
    }
    
   
    
    public int convert(char c){
        if(c=='I'){
            return 1;
        }
        else if(c=='V'){
            return 5;
        }
        else if(c=='X'){
            return 10;
        }
        else if(c=='L'){
            return 50;
        }
        else if(c=='C'){
            return 100;
        }
        else if(c=='D'){
            return 500;
        }
        else if(c=='M'){
            return 1000;
        }
        else{
            return 0;
        }
    }
    
    
    
    
    public boolean isPalindrome(String str) {
        int j=str.length()-1;
        int flag1 =0, flag2 =0;
        String s = str.toLowerCase();
        for(int i=0;i<s.length();i++){
            //System.out.println(" i " + i + "j " + j);
            int ascii_val1 = s.charAt(i);
            int ascii_val2 = s.charAt(j);
            flag1=0;
            flag2=0;
            if(j>=i){
                //check whitspace
                if((ascii_val1 >= 48 && ascii_val1 <= 57) || (ascii_val1 >= 65 && ascii_val1 <= 90) || (ascii_val1 >= 97 && ascii_val1 <= 122) ){
                    flag1=1;
                }
                else{
                    continue;
                }
                if((ascii_val2 >= 48 && ascii_val2 <= 57) || (ascii_val2 >= 65 && ascii_val2 <= 90) || (ascii_val2 >= 97 && ascii_val2 <= 122)){
                    flag2=1;
                }
                else{
                    j--;
                    i--;
                    continue;
                }
                
                if(flag1==1 && flag2==1){
                    if(s.charAt(i) != s.charAt(j)){
                        return false;
                    }
                }
            }
            else{
                break;
            }
            if(i==j) {
                break;
            }
            j--;
            
        }
        return true;
    }

public static boolean detectCapitalUse(String word) {
        int len = word.length();
        int caps=0,i=1;
        //last char is capital letter
        if(((word.charAt(len-1)>=65) && (word.charAt(len-1)<=90)) && ((word.charAt(0)>=65) &&                         (word.charAt(0)<=90))){
            caps=1;
        }
        else if(((word.charAt(len-1)>=97) && (word.charAt(len-1)<=122)) && (((word.charAt(0)>=65) &&                         (word.charAt(0)<=90)) || ((word.charAt(0)>=97) && (word.charAt(0)<=122)))){
            caps=0;
        }
        else{
            return false;
        }
        
        //checking the word if all caps
        if(caps==1){
            while(i<len-1){
                if((word.charAt(len-1-i)>=65) && (word.charAt(len-1-i)<=90)){
                    i++;
                }
                else{
                    return false;
                }
            }
        }
        
        //checking if all small
        else{
            while(i<len-1){
                if((word.charAt(len-1-i)>=97) && (word.charAt(len-1-i)<=122)){
                    i++;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }

    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        String str ="1";
        return count(1,n,str);
    }
    
    //recursive count and say
    public String count(int itr,int n,String str){
        String s= "";
        if(itr==n){
            return str;
        }
        else{
            int count =1;
            int len = str.length();
            
            for(int i=0;i<len;i++){
                count=1;
                char cur = str.charAt(i);
                int k=i+1;
                while(k<len){
                    if(cur == str.charAt(k)) {
                        count++;
                    }
                    else{
                        break;
                    }
                    k++;
                }
                    s += Integer.toString(count);
                    s += String.valueOf(str.charAt(i));
                    i = k-1;
            }
        }
            return count(++itr,n,s);
        
    }
    

    
    
    
    public int lengthOfLongestSubstring(String s) {
        int len=0;
        
        return len;
    }
}//end class


