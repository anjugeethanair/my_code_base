/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package char_array;

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
                // TODO code application logic here
        char_array ch = new char_array();
        String str = new String();
        char[] arr1 = {'(',')','(',')','('};
        //System.out.println(ch.balancedBraces(arr));
        
        System.out.println(ch.palindrome_book("mam"));
        
        //Test case for problem1
		char[] arr2 = {'a',' ','b','c','\0'};
                //char[] newarr = new char[arr2.length];
		char[] newarr = ch.reverse(arr2);
		for(int i=0;i<newarr.length;i++){
		    System.out.print(newarr[i] + " ");
		}
		
		//Test case for problem2
		//String str= "abccda";
		//System.out.println(duplicateChar(str));
		
		//Test case for problem3
		String s1 = "sseis";
		String s2 = "ssesi";
		System.out.println(ch.anagram(s1,s2) + " ");
		
		//Test case for problem4
		String str1 = "My name is    Ann   Juu  DDeee";
		System.out.println(ch.replaceSpace(str1));
		
		//Test case for problem5
		char[][] matrix = {{'1','2','3'},{'4','0','5'},{'2','1','0'},{'5','8','9'}};
		matrix = ch.replaceZero(matrix);
		for(int i=0;i<matrix.length;i++){
		    for(int j=0;j<matrix[0].length;j++){
		        System.out.print(matrix[i][j] + "  ");

		    }
		    System.out.println();
		}
                
                //Test case for problem6
		int[][] matrixR = {{1,2,3,4,3},{4,0,0,9,3},{2,1,0,8,3},{0,8,9,5,3},{5,6,7,8,3}};
		matrixR = ch.matrixRotation(matrixR);
		for(int i=0;i<matrixR.length;i++){
		    for(int j=0;j<matrixR[0].length;j++){
		        System.out.print(matrixR[i][j] + "  ");

		    }
		    System.out.println();
		}
                
                //test case for longest common prefix
                String lcp1 = "apple";
                String lcp2 = "applet";
                System.out.println(ch.longestprefix(lcp1, lcp2));
                
                
                //test case for square matrix transpose
                int[][] arr3 = {{1,2,3},{4,0,5},{2,1,0}};
                int[][] stranspose = ch.squaretranspose(arr3);
                for(int i=0;i<stranspose.length;i++){
		    for(int j=0;j<stranspose[0].length;j++){
		        System.out.print(stranspose[i][j] + "  ");

		    }
		    System.out.println();
		}
                
                //test case for transpose N*M
                int[][] arr4 = {{1,2,3},{4,0,5}};
                int[][] transpose = ch.transpose(arr4);
                for(int i=0;i<transpose.length;i++){
		    for(int j=0;j<transpose[0].length;j++){
		        System.out.print(transpose[i][j] + "  ");

		    }
		    System.out.println();
		}
                
                //Test case for charater count
                String str5 = "vhuiiu";
                ch.characterCount(str5);
                
                //test case for longest common prefix
                String[] strarr = {"geeks", "geeksforgeeks", "geezer"};
                System.out.println(ch.arrayPrefix(strarr));
                
                //test case for smallest in rotated array
                int[] rarr = {5,6,7,8,9,4};
                System.out.println(ch.smallestinRotated(rarr));
                
                //testcase for longest palindrome
                String lps = "abanana";
                ch.palindromicSubstring(lps);
                String lps1 = "abacadabra";
                ch.palindromicSubstring(lps1);
                String lps2 = "cobra";
                ch.palindromicSubstring(lps2);
                String lps3 = "c";
                ch.palindromicSubstring(lps3);
                String lps4 = " ";
                ch.palindromicSubstring(lps4);
                String lps5 = "";
                ch.palindromicSubstring(lps5);
                String lps6 = "malayalam";
                ch.palindromicSubstring(lps6);
                String lps7 = "applet";
                ch.palindromicSubstring(lps7);
                //String lps7 = "";
                //ch.palindromicSubstring(lps7);
                
                //test case for chararter replace with ktimes character
                System.out.println(ch.characterReplace("abc",26));
                //test case for non-repeating character in string
                System.out.println(ch.nonRepeatingChar("GeekQuiz"));
                //test case for string palindrome after shifting
                System.out.println(ch.shiftPalindrome("bbccbbaa"));
                //test case for smallest alphabet greater than given char
                char[] apha = {'b','d','n','q','s'};
                System.out.println("smallest alpha greater than b  " +ch.smallestAlpha(apha,'r'));
                System.out.println("smallest alpha greater than b  " +ch.smallestAlphaVishak(apha,'r'));
                System.out.println("string2 rotated of string1  " + ch.stringRotation("ABACD", "CADBA"));
                //test case for balanced parantheses
                char[] balan = {')','('};
                System.out.println("balanced paranthese  "+ch.balancedparan(balan));
                //test case for string reversal
                System.out.println("reversed string  "+ch.i_reverseString("adkbc"));
                //System.out.println("reversed string emitting vowels  "+ch.reverseStringVowels("geeksforgeeks"));
                char[] test = {'A','B','C','F','G','F','P','G'};
                
                System.out.println(ch.countgfg(test));
                
                //Remove all occurrences of a character in a string
                System.out.println(ch.removeChar("geekforgeeks",'e'));
                System.out.println(ch.countSubstrings("abbcaceghcak",'a','c'));
                
                System.out.println(ch.countSubstring("geeksforgeeks","geek"));
                System.out.println("count  "+ch.countKOnes("10010", 1));
                
                System.out.println("counts  "+ch.shortestDeletion("aaabccddd"));
                
                char[] char_array = {'e','e','e','e','k','g','e','e','e'};
                char[] out = ch._inplaceunique(char_array);
                System.out.println(new String(out));
                
	}
    }
    
/*
https://codingbat.com/prob/p147538 --completed 10:44 -11:14
https://www.geeksforgeeks.org/remove-all-occurrences-of-a-character-in-a-string/--            11:17-11:32
https://www.geeksforgeeks.org/count-substrings-that-starts-with-character-x-and-ends-with-character-y/  11:35-11:45 & 3:39-4:05
https://www.geeksforgeeks.org/count-occurrences-of-a-substring-recursively/    4:10-4:47


*/