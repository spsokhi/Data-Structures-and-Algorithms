class Solution {
public:
    int findCircleNum(vector<vector<int>>& isConnected) {
        int size = isConnected.size();
        vector<bool>vis(size, false);
        int cnt = 0;
        
        // Connected components
        for(int cur = 0; cur<size; cur++){
            if(!vis[cur]){
                cnt++;
                traverseGroup(cur, isConnected, vis, size);
            }
        }
        
        return cnt;
    }
    
private:
    // DFS
    void traverseGroup(int cur, vector<vector<int>>& isConnected, vector<bool>& vis, int size){
        vis[cur] = true;
        for(int nxt=0; nxt<size; nxt++){
            if(isConnected[cur][nxt] && !vis[nxt])
                traverseGroup(nxt, isConnected, vis, size);
        }
    }
};