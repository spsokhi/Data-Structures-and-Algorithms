//{ Driver Code Starts
import java.util.*;


class Remove_Duplicate_From_String
{
	public static void main(String args[])
	{
		Scanner sc  = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		while(T>0)
		{
			String str1 = sc.nextLine();
			String arr[] = str1.split(" ");
			//String str1 = sc.nextLine();
			//sc.skip("\\s*");
			String str = arr[arr.length-2];
			int K = Integer.parseInt(arr[arr.length-1]);
			
			//int K = Integer.parseInt( sc )
			//sc.nextLine();
			//sc.nextInt();
			
			
			//GfG g = new GfG();
			//System.out.println(str);
			//System.out.println(K);
			//System.out.println(new GfG().is_k_palin(str, K));

                       boolean b = new GfG().is_k_palin(str, K);
			if(b == true)
				System.out.println(1);
			else
				System.out.println(0);
			
			
		T--;
		}
	}
}
// } Driver Code Ends


class GfG
{
     static int solver(int n, int m, String str1, String str2,int [][] dp) {
     
          if(m==0||n==0)
        return 0;
        if(dp[n][m]!=-1)
        return dp[n][m];
        if(str1.charAt(n-1)==str2.charAt(m-1)){
             dp[n][m] =1+solver(n-1,m-1,str1,str2,dp);
        }
        else{
              dp[n][m]= Math.max(solver(n,m-1,str1,str2,dp),
                            solver(n-1,m,str1,str2,dp));
        }
        return dp[n][m];
         
     }
     
    boolean is_k_palin(String str1, int k)
    {
	// Your code here
	  int n=str1.length();
         int m=str1.length();
         
         if(n<=k)
         return true;
         
        String str2="";
        for(int i=n-1;i>=0;i--)
        str2+=str1.charAt(i);
    
         int dp[][]=new int [n+1][m+1];
        for(int i=0;i<=n;i++)
        Arrays.fill(dp[i],-1);
        
        solver(n,m,str1,str2,dp);
        if(str1.length()-dp[n][m]<=k)
        return true;
        else return false;
        // return solver(n,m,str1,str2,dp);
    }
}
