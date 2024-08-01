//{ Driver Code Starts
import java.util.Arrays;
import java.util.Scanner;
class FindFourElements
{
	
    public static void main(String[] args) 
    {
		Scanner sc=new Scanner (System.in);
		int t=sc.nextInt();
		while(t-->0){
			FindFourElements findfour = new FindFourElements();
			int n=sc.nextInt();
			int[] A=new int[n];
			for(int i=0;i<n;i++)
				A[i]=sc.nextInt();
			int X =sc.nextInt();
			
			Compute ob = new Compute();
		    System.out.println(ob.find4Numbers(A, n, X)?1:0);
		}
    }
}


// } Driver Code Ends


class Compute
{
    boolean find4Numbers(int A[], int n, int X) 
    {
        Arrays.sort(A);
        
        
        for(int i=0;i<n;i++){
            for(int j=n-1;j>=0;j--){
                int k=i+1;
                int l=j-1;
                while(k<l){
                    if(A[i]+A[j]+A[k]+A[l]==X) return true;
                   else if(A[i]+A[j]+A[k]+A[l]<X) k++;
                   else l--;
                }
                
            }
        }
        return false;
    }
}