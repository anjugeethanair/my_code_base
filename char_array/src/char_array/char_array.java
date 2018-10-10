/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package char_array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author Anju
 */
public class char_array {
    
    /**
     * @param args the command line arguments
     */
    ArrayList<Integer> q_arr = new ArrayList<Integer>();
    public boolean balancedBraces(char[] arr){
        Stack<Character> s = new Stack();
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='('){
                s.push('(');
            }
            else if(arr[i]==')'){
                if(!s.isEmpty()){
                    s.pop();
                }
                else{
                    return false;
                }
            }
        }
        if(s.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean palindrome(String str) {
        if(str.length()%2!=0) {
            return _palindrome(str, str.length()/2-1, str.length()/2+1);
        }
        else {
            return _palindrome(str, str.length()/2-1, str.length()/2);
        }
        
    }
    private boolean _palindrome(String str, int left, int right) {
        if(str.charAt(left)  == str.charAt(right)) {
            if(left==0) {
                return true;
            }
            return _palindrome(str, left-1, right+1);
        }
        else {
            return false;
        }
    }
   
    public boolean palindrome_book(String str) {
        if(str.length()<=1) {
            return true;
        }
        if(str.charAt(0)  == str.charAt(str.length()-1))
        {
            return palindrome_book(str.substring(1, str.length()-1));
        }
        else {
            return false;
        }
    }
       
    
    public char[] reverse(char[] arr){
	    int n= arr.length;
	    if(n==1){
	       System.out.println("empty array");
	    }
	    char[] newarr = new char[n-1]; 
	    for(int i=0;i<n-1;i++){
	        newarr[i] = arr[n-2-i];
	    }
	    return newarr;
    }
/*rotate matrix by 90 degree*/
    public int[][] matrixRotation(int[][] a){
   	int temp;
   	int n=a.length;
   	int[][] newarr = new int[n][n];
    	for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
    		newarr[i][j] = a[j][n-1-i];			
    			//a[n-1-j][i] = temp;
            }
    	}
    	return newarr;
    }
    
    public int smallestinRotated(int[] a){
        int pivot=a[a.length-1];
        int min =Integer.MAX_VALUE;
        if(pivot>a[0]){
            return a[0];
        }
        for(int i=0;i<a.length;i++){
            if(a[i]<=pivot){
                min= a[i];
                break;
            }
        }
        return min;
        
    }
    public boolean anagram(String str1,String str2){
        
        if(str1.length()!=str2.length()){
            return false;
        }
        String s1 = str1.toLowerCase();
        String s2 = str2.toLowerCase();
        //String copys2 = s2;
        char[] chararr1 = s1.toCharArray();
        char[] chararr2 = s2.toCharArray();
        
        for(int i=0;i<chararr1.length;i++){
            for(int j=0;j<chararr2.length;j++){
                //if(s1.charAt(i)==s2.charAt(j)){
                    //String newstr = s2.substring(0,j)+'0'+s2.substring(j+1);
                if(chararr1[i]==chararr2[j]){
                    chararr2[j] = '\0';
                    break;
                }
            }
        }
        
        for(int i=0;i<chararr2.length;i++){
            if(chararr2[i] != '\0'){
                return false;
            }
        }
        return true;
    }
    
    
    
    public String replaceSpace(String str){
        //for(int i=0;i<str.length();i++){
            //if(Character.isWhitespace(str.charAt(i))){
                String stringnospace = str.replaceAll("\\s+","%20");
          //  }
        //}
        return stringnospace;
    }
    
    
    public char[][] replaceZero(char[][] arr){
        int[] row = new int[arr.length];
        int[] col = new int[arr[0].length];

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]=='0'){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(row[i]==1 || col[j]==1){
                    arr[i][j] = '0';
                }
            }
        }
       return arr; 
    }
    public int[][] squaretranspose(int[][] arr3){
        int temp = 0;
        for(int i=0;i<arr3.length;i++){
            for(int j=0;j<arr3[0].length;j++){
                if(j>=i){
                    temp= arr3[i][j];
                    arr3[i][j] = arr3[j][i];
                    arr3[j][i] = temp;
                }
                
            }
        }
        return arr3;
    }
    
    //N*M matrix transpose
    public int[][] transpose(int[][] arr4){
        int[][] newarr4 = new int[arr4[0].length][arr4.length];
        int temp = 0;
        for(int i=0;i<arr4.length;i++){
            for(int j=0;j<arr4[0].length;j++){
                    newarr4[j][i] = arr4[i][j];
            }
        }
        return newarr4;
    }
    
    //longest common prefix
    public String longestprefix(String s1,String s2){
        String prefix = "";
        int small =0;
        if(s1.length()<= s2.length()){
            small = s1.length();
        }
        else{
            small = s2.length();
        }
        for(int i=0;i<small;i++){
            if(s1.charAt(i)==s2.charAt(i)){
                prefix += s1.charAt(i);
            }
            else{
                break;
            }
        }
        return prefix;
    }
    
    //longest palindromic substring
    public void palindromicSubstring(String str) {
        Map<Integer,String> map = new HashMap<Integer,String>();
        int n = str.length();
        if(n==0){
            return;
        }
        for(int i=0;i<n;i++){
            _palindromicSubstring(str.substring(i,str.length()), map);
        }
        while(n>1){
            //for(int value : map.values()){
                if(map.containsKey(n)){
                    System.out.println(map.get(n));
                    break;
                }
            //}
            n--;
        }
        if(n==1){
            System.out.println("no palindrome");
        }
        
    }
    
    private void _palindromicSubstring(String str,Map<Integer,String> map) {
        if(palindrome_book(str)) {
            map.put(str.length(),str);
        }
        else{
             _palindromicSubstring(str.substring(0, str.length()-1),map);
        }
    }
    
    //character count in a string    
    public void characterCount(String str1){
        int[] arr = new int[26];
        int max = 0;
        for(int i=0;i<str1.length();i++){
            arr[str1.charAt(i)-97]++;
            if(max<arr[str1.charAt(i)-97]){
                max = arr[str1.charAt(i)-97]; 
            }
        }
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]==max){
                int val = i+97;
                char c = (char)(val);
                System.out.print(c+ " ");
            }
        }
        System.out.println();
        
    }
    
    //longest common prefix in an array of strings
    public String arrayPrefix(String[] string_arr){
        String longPrefix = "";
        if(string_arr.length==1){
            return string_arr[0];
        }
        longPrefix  = longestprefix(string_arr[0],string_arr[1]);
        for(int i=2;i<string_arr.length;i++){
            longPrefix  = longestprefix(longPrefix,string_arr[i]);
        }
        return longPrefix;
    }
    
    //longest common prefix in an array of strings
    public void lastn(String str, int n){
        int beg_index[] = new int[n];
        int i=0;
        int index = 0;
        int count = -1;
        
        while(i<str.length()) {
            if(str.charAt(i) == '\n') {
                beg_index[index] = i;
                index += (index + 1) % n;
                count++;
                if(count == n-1) {
                    count = 0;
                }
            }
            i++;
        }
        if(count<n-1) {
            count++;
        }
        else {
            count = 0;
        }
        for(int j=count;(j+1)%n!=count;j++) {
            str.substring(beg_index[j]);
        }

        

    }
    
    public String characterReplace(String replace,int k){
        String str="";
        for(int i=0;i<replace.length();i++){
            int val = replace.charAt(i);
            val += k;
            if(val>=123){
                k -= 26;
                val = replace.charAt(i);
                val += k;
            }
            
            str += (char) val;
        }
        return str;
    }
    
    
    //First non-repeating character using one traversal of string
    public char nonRepeatingChar(String nonrep){
        char[] arr = new char[256];
        for(int i=0;i<nonrep.length();i++){
            int val = nonrep.charAt(i);
            arr[val]++;
        }
        for(int j=0;j<nonrep.length();j++){
            int val = nonrep.charAt(j);
            if(arr[val]==1){
                return (char)val;
            }
        }
        return (char)Integer.MAX_VALUE;
    }
    
    //string palindrome upon shifting
    public int shiftPalindrome(String str){
        int count=-1,i=0,j=str.length()-1,flag =0;
        //String s = str;
        while(count<str.length()-1 && j>i){
            while(j>i){
                if(str.charAt(i)!=str.charAt(j)){
                    i=0;
                    j=str.length()-1;
                    break;
                }
                i++;
                j--;
            }
            str = str.substring(1)+ str.charAt(0);
            count++;
        }
        return count;
    }
    
    //Smallest alphabet greater than a given character
    public char smallestAlpha(char[] alpha,char k){
        return _smallestAlpha(alpha,k,0,alpha.length-1);
    }
    private char _smallestAlpha(char[] alpha,char k,int low,int high){
        int mid = (high+low)/2;
        if(alpha[mid]==k && low==0){
            return alpha[1];
        }
        if(alpha[mid]==k && high==alpha.length-1){
            return alpha[0];
        }
        if(alpha[mid]<k){
            if(high==mid+1 && alpha[mid+1]!=k){
                return alpha[alpha.length-1];
            }
            return _smallestAlpha(alpha,k,mid+1,high);
        }
        else{
            if(low==mid-1){
                return alpha[low];
            }
            return _smallestAlpha(alpha,k,low,mid-1);
        }
        
    }
    
        
    //Smallest alphabet greater than a given character
    public char smallestAlphaVishak(char[] alpha,char k){
        char ans = _smallestAlphaVishak(alpha,k,0,alpha.length-1);
        if('\0' == ans) {
            return alpha[0];
        }
        return '\0';
    }
    private char _smallestAlphaVishak(char[] alpha,char k,int low,int high){
        int mid = (high+low)/2;
        if((low >= high)){
            if(alpha[low]>k) {
                return alpha[low];
            }
            return '\0';
        }
        if(alpha[mid]==k){
            return _smallestAlphaVishak(alpha,k,mid+1,high);
        }
        if(alpha[mid]<k){
            return _smallestAlphaVishak(alpha,k,mid+1,high);
        }
        else{
           char smaller =  _smallestAlphaVishak(alpha,k,low,mid-1);
           if(smaller != '\0') {
               return smaller;
           }
           else {
               return alpha[mid];
           }
        }
        
    }
    
    // Check if strings are rotations of each other or not
    public boolean stringRotation(String str1,String str2){
        if(str1.length()!=str2.length()){
            return false;
        }
        int j=0,index=0,flag=0;
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        for(int i=0;i<s1.length;i++){
            if(s1[i]==s2[j]){
                if(flag==0){
                    index=i;
                    flag=1;
                }
                j++;
            }
            else if(flag==1 && s1[i]!=s2[j]){
                return false;
            }
        }
        
        for(int k=0;k<index;k++){
            if(s1[k]==s2[j]){
                j++;
            }
            else{
                return false;
            }
        }
        return true;
    }
    
    //Check for balanced parentheses in an expression | O(1) space
    public boolean balancedparan(char[] bal){
        int s=0,m=0,l=0;
        for(int i=0;i<bal.length;i++){
            if(bal[i]=='(') {
                s++;
            }
            else if(bal[i]=='{'){
                l++;
            }
            else if(bal[i]=='['){
                m++;
            }
            else if(bal[i]==')'){
                if(s<=0){
                    return false;
                }
                s--;
            }
            else if(bal[i]==']'){
                if(m<=0){
                    return false;
                }
                m--;
            }
            else if(bal[i]=='}'){
                if(l<=0){
                    return false;
                }
                l--;
            }
        }
        if(s==0 && m==0 && l==0){
            return true;
        }
        else{
            return false;
        }
    }
    
    //reverse a string
    public String i_reverseString(String str){
       char[] reverse = str.toCharArray();
       int j= reverse.length-1;
       char temp;
       for(int i=0;i<reverse.length;i++){
           if(j<=i){
               break;
           }
           temp = reverse[i];
           reverse[i]=reverse[j];
           reverse[j]=temp;
           j--;
       }
       return new String(reverse);
    }
    
    //reverse a string omitting vowels
    public String reverseStringVowels(String str){
       char[] reverse = str.toCharArray();
       int j= reverse.length-1;
       int count =0;
       char temp;
       for(int i=0;i<reverse.length;i++){
           if(j<=i){
               break;
           }
           if(reverse[i]!='a'&& reverse[i]!='e'&& reverse[i]!='i'&& reverse[i]!='o'&& reverse[i]!='u'){
            temp = reverse[i];
            reverse[i]=reverse[j];
            reverse[j]=temp;
           }
           else{
               reverse[i]='0';
               reverse[j] ='0';
               count+=2;
           }
            j--;
       }
       j=0;
       char[] newarr = new char[count];
       for(int i=0;i<reverse.length;i++){
           if(reverse[i]!='0'){
            newarr[j]= reverse[i];
            if(j==count){
                break;
            }
            j++;
           }
       }
       return new String(newarr);
    }
    
     //reverse a string omitting vowels
    public char[] reverseStringVowelsVishak(String str){
        char[] strch = str.toCharArray();
        char[] newarr = new char[str.length()];
        int i = 0;
        int j = str.length()-1;
        int newarrind=0;
        for(int k=0;k<str.length();k++) {
            if(strch[i]!='a'&& strch[i]!='e'&& strch[i]!='i'&& strch[i]!='o'&& strch[i]!='u'){
                newarr[newarrind++] = strch[j];
            }
            j--;
        }
        return strch;
    }
    
    
     //Remove all occurrences of a character in a string
    public String removeChar(String removechar,char c){
        /*String removed = "";
        for(int i=0;i<removechar.length();i++){
            if(removechar.charAt(i)!=c){
                removed +=removechar.charAt(i);
            }
        }
        return removed; */
        
        int n = removechar.length();
        for(int i=0;i<n;i++){
            if(removechar.charAt(i)!=c){
                removechar += removechar.charAt(i);
            }
        }
        return removechar.substring(n,removechar.length());
        
    }
    
    //Count substrings that starts with character X and ends with character Y
    public int countSubstrings(String s,char x,char y){
        int[] xindex = new int[s.length()];
        int[] yindex = new int[s.length()];
        int j=0,k=0,count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==x || s.charAt(i)==y){
                if(s.charAt(i)==x){
                    xindex[j++] = i;
                }
                if(s.charAt(i)==y){
                    yindex[k++] = i;
                }
            }
        }
        int start1=0,start2=0;
        while(start1<j){
            while(start2<k){
                if(xindex[start1]<yindex[start2]){
                    count += k-start2;
                    break;
                }
                else{
                    start2++;
                }
                
            }
            start1++;
            start2=0;
        }
        return count;
    }
    
    
    public int countSubstring(String s1,String s2){
        if(s1.length()<s2.length()){
            return 0;
        }
        if(s1.substring(0, s2.length()).equals(s2)){
            return countSubstring(s1.substring(1, s1.length()),s2)+1;
        }
        else{
            return countSubstring(s1.substring(1, s1.length()),s2);
        }
    }
     
    public int countgfg(char[] str) {
        int result=0;
        int count=0;
        for(int i=0;i<str.length;i++) {
            if(str[i] == 'g') {
                if(count == 0) {
                    count++;
                }
                else if(count == 2) {
                    result++;
                    count = 0;
                }
                else {
                    count = 0;
                }
            }
            else if(str[i] == 'f') {
                if(count == 1) {
                    count++;
                }
            }
            else {
                count = 0;
            }
        }
        return 0;
    }
    
    //Smallest sum contiguous subarray
    public int sumSubArray(int[] arr){
        int min = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            int sum=0;
            for(int j=0;j<arr.length;j++){
                sum += arr[j];
                if(min>sum){
                    return min;
                }
            }
            
        }
        return min;
    }
    
    //Array elements that appear more than once
    public int[] moreThanOnce(int[] arr){
        Set<Integer> set = new HashSet<Integer>();
        int j=0;
        int[] repeat = new int[arr.length-1];
        for(int i=0;i<arr.length;i++){
            if(set.contains(arr[i])){
                repeat[j++] = arr[i];
            }
            else{
                set.add(arr[i]);
            }
        }
        return repeat;
    }
    
    //Count of substrings of a binary string containing K ones
    public int countKOnes(String str, int k){
        int sum=0,count=0;
        for(int i=0;i<str.length();i++){
            for(int j=i;j<str.length();j++){
                if(str.charAt(j)=='1'){
                    count++;
                }
                if(count==k){
                    ++sum;
                }
            }
            count=0;
        }
        return sum;
    }
    
    //Reduce string to shortest length by deleting a pair of same adjacent characters
    public int shortestDeletion(String str){
        int count=0;
        if(str.length()<2){
            if(str.charAt(0)==str.charAt(1)){
                return 1;
            }
        }
        for(int i=1;i<str.length();i++){
            if(str.charAt(i-1)==str.charAt(i)){
                count++;
                i++;
            }
        }
        return count;
    }
        boolean isVowel(char c){
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
            return true;
        }
        else{
            return false;
        }
    
    }
    //Modify string by removing vowels in between two consonants
    public String removeVowelsInBetweeen(String str){
        String newstr ="";
        
        if(str.length()<3){
            return str;
        }
        str.toLowerCase();
        for(int i=1;i<str.length();i++){
            if(isVowel(str.charAt(i))){
                if((isVowel(str.charAt(i-1))==false) && (isVowel(str.charAt(i+1))==false)) {
                    newstr += str.charAt(i-1)+str.charAt(i+1);
                }
            }
            else{
                newstr += str.charAt(i);
            }
        }
        return newstr;
    }
    

    /*arraylist implementing queue*/
    
    //add element to end of arraylist
    public void q_add(int data){
        int flag=0;
        for(int i=0;i<q_arr.size();i++){
            if(q_arr.get(i)==null){
                q_arr.add(data);
                flag=1;
            }
        }
        if(flag==0){
            q_arr.add(data);
        }
    }
    
    //remove and return the element from beginning of arraylist
    public int q_remove(){
        int temp = Integer.MAX_VALUE;
        if(q_arr.size()!=0){
           temp = q_arr.get(0);
        }
        for(int i=0;i<q_arr.size()-1;i++){
            q_arr.add(i,q_arr.get(i+1));
        }
        return temp;        
    }
    
    //returns first value of the arraylist
    public int q_peek(){
        int temp = Integer.MAX_VALUE;
        if(q_arr.size()!=0){
           temp = q_arr.get(0);
        }
        return temp;
    }

    public char[] _inplaceunique(char[] val) {
        int pos = 0;
        for(int i=0;i<val.length-1;) {
            if(val[i] == val[i+1]) {
                int k=i+1;
                while((k+1)<val.length) {
                    if(val[k]==val[k+1]) {
                        k++;
                    } else {
                        break;
                    }
                }
                val[pos++] = val[i];
                i=k+1;
            } else {
                val[pos++] = val[i];
                i++;
            }
        }
        if(val[val.length-2]!=val[val.length-1]) {
            val[pos++] = val[val.length-1];
        }
        val[pos++] = 0;
        return val;
    }
    
}
