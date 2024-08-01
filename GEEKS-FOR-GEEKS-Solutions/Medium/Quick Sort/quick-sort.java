//{ Driver Code Starts
import java.util.*;
class Sorting
{
	static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    
    // Driver program
    public static void main(String args[])
    {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();

			
			new Solution().quickSort(arr,0,n-1);
			printArray(arr);
		    T--;
		}
} }
// } Driver Code Ends




class Solution
{
    //Function to sort an array using quick sort algorithm.
    
    // swap the i,j index
      static void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	// swap the low to a random index to prevent from worst case operations
	static void random(int a[], int l, int h) {
		int randomIndex = l + (int)(Math.random() * (h-l+1));
		swap(a, l, randomIndex);
	}
	
	// find the correct position of the pivot element
	static int partition(int a[], int l, int h) {
		int i = l;
		int j = h;
		random(a, l, h);
		int pivot = a[l];
		while(i < j) {
			while(i < j && a[i] <= pivot) i++;
			while(a[j] > pivot) j--;
			if(i < j) {
				swap(a, i, j);
			}
		}
		swap(a, l, j);
		return j;
	}
	 // perform the partition in left part of pivot
	 // and right part of pivot
	 // by using recursive leap of faith.
	static void quickSort(int a[], int l, int h) {
		if(l < h) {
			int pivot = partition(a, l, h);
			quickSort(a, l, pivot-1);
			quickSort(a, pivot+1, h);
		}
	}
}