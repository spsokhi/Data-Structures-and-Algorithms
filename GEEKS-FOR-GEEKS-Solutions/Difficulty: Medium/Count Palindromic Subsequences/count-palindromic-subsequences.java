//{ Driver Code Starts
import java.util.*;
class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			//System.out.println(str.length());
			Solution ob  = new Solution();
			System.out.println(ob.countPS(str));
		t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete below method */

class Solution
{   
    int mod= 1000000007;
    static long [][] dp = new long [1001][1001];
    long countPS(String str)
    {
        int j= str.length(), i=0;
        for(long[] row: dp){
            Arrays.fill(row,-1);
        }
        return solver(i,j-1,str);
    }
    long solver(int i, int j, String str){
        if(i==j){
            return 1;
        }
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(str.charAt(i)==str.charAt(j)){
            return dp[i][j]= (solver(i+1,j,str)%mod+solver(i,j-1,str)%mod+1+ mod)% mod;
        }
        else{
            return dp[i][j]=( mod + solver(i+1,j,str)%mod+solver(i,j-1,str)%mod-solver(i+1,j-1,str)%mod)%mod;
        }
    }
}