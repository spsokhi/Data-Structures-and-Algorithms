//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        while (T > 0) {
            String[] input = sc.nextLine().trim().split(" ");
            int[] a = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                a[i] = Integer.parseInt(input[i]);
            }
            Solution ob = new Solution();
            ob.segregateElements(a);
            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
            T--;
        }
        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public void segregateElements(int[] arr) {
        // Your code goes here
        int i=0;
        int j=0;
        int res=0;
        int tmp[]= new int[arr.length];
       while(j<arr.length){
        //   if(arr[0]>=0) continue;
       
            if(arr[j]>=0){
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
                 i++;
                 
            } 
            else{
                tmp[res++]=arr[j];
            }
            j++;
        }
        int k=0;
        for(int index=0;index<arr.length;index++)
        if(arr[index]<0){
            arr[index]=tmp[k++];
        }
    }
}