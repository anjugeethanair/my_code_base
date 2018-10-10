/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

/**
 *
 * @author Anju
 */
public class arrays {
    int[] arr;
    int[][] arr2d;
    
    public arrays(int[] arr){
        this.arr = arr;
    }
    public arrays(int[][] arr2d){
        this.arr2d = arr2d;
    }
    
    
    public int binarySearch(int lo,int high,int num){
        int mid = (high+lo)/2;
        if(high<lo){
            return Integer.MAX_VALUE; 
        }
        
        else{
            if(num<arr[mid]){
                return binarySearch(lo,mid-1,num); 
            }
            else if(num>arr[mid]){
                return binarySearch(mid+1,high,num); 
            }
            else{
                return mid; 
            }
        }
    }
    
        //2d matrix array search
    public int[] matbinarySearch(int lo,int high,int num,int n){
        int[] index = new int[2];
        
        int mid = (high+lo)/2;
        if(high<lo){
            index[0] = -1;
            index[1] = -1;
            return index; 
        }
        else{
            if(num<arr2d[mid/n][mid%n]){
                return matbinarySearch(lo,mid-1,num,n); 
            }
            else if(num>arr2d[mid/n][mid%n]){
                return matbinarySearch(mid+1,high,num,n); 
            }
            else{
                index[0] = mid/n;
                index[1] = mid%n;
                return index; 
            }
        }
        
    }
    
    public boolean setUnset(int num){
        int[] count = new int[2];
        int remainder=0,val;
        if(num==0){
            return false;
        }
        while(num>0){
            val =num;
            num = num/2;
            remainder = val%2;
            if(remainder==0){
                count[0]++;
            }
            else{
                count[1]++;
            }
        }
        if(count[0]==count[1]){
            return true;
        }
        else{
            return false;
        }
    }
    
    public String kValue(int[] arr,int k){
        int val=k,prime=1;
        for(int i=0;i<arr.length;i++){
            prime =1;
            for(int j=2;j<=arr[i]/2;j++){
                if(arr[i]%j==0){
                    prime=0;
                    break;
                }
            }
            if(prime==0){
                k--;
            }
            else{
                k = val;
            }
        }
        if(k>0){
            return "yes";
        }
        else{
            return "no";
        }
    }

}
