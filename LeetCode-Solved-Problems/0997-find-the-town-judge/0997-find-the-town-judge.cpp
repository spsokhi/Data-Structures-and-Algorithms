class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        map<int,int>in,out;
        for(int i=0;i<trust.size();i++)
            out[trust[i][0]]++, in[trust[i][1]]++;
        
        for(int i=1; i<=n; i++)
            if(in[i]==n-1 and out[i]==0)return i;
        
        return -1;
    }
};