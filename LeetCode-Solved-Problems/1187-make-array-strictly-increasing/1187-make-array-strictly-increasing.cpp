class Solution {
public:
    
    short dp[2001][2001][2]={},mx=2002;
    short dfs(vector<int>&f, vector<int>&s, int i, int j, bool prev_el){
        if(i>=f.size())return 0;
        int prev = prev_el? i==0? INT_MIN : f[i-1]:s[j];
        j = upper_bound(s.begin(),s.end(),prev)-s.begin();
        if(dp[i][j][prev_el]==0){
            dp[i][j][prev_el]=mx;
            if(j<s.size())
                dp[i][j][prev_el] = dfs(f,s,i+1,j,false)+1;
            if(prev<f[i])
                dp[i][j][prev_el]=min(dp[i][j][prev_el],dfs(f,s,i+1,j,true));
        }
        
        
        return dp[i][j][prev_el];
    }
    int makeArrayIncreasing(vector<int>& arr1, vector<int>& arr2) {
        sort(arr2.begin(),arr2.end());
        auto ans = dfs(arr1,arr2,0,0,true);
        return ans >= mx ? -1 : ans;
    }
};

// see this:
// https://leetcode.com/problems/make-array-strictly-increasing/discuss/379095/C%2B%2B-DFS-%2B-Memo 