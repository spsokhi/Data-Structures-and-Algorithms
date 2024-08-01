class Solution {
    #define ll long long
public:
    int maximumDetonation(vector<vector<int>>& bombs) {
        int size = bombs.size();
        vector<vector<int>>adj = buildBombNetwork(bombs, size);
        
        int mx_count = INT_MIN;
        for(int i =0; i<size;i++){
            vector<bool>vis(size, false);
            detonate(i, adj, vis);
            int cnt = 0;
            for(int bomb=0; bomb<vis.size(); bomb++){
                cnt+=vis[bomb];
            }
            mx_count = max(mx_count, cnt);
        }
        
        return mx_count;
    }
    
private:
    vector<vector<int>> buildBombNetwork(vector<vector<int>>& bombs, int size){
        vector<vector<int>> adj(size);
        for(int src=0; src<size; src++){
            ll x1 = bombs[src][0];
            ll y1 = bombs[src][1];
            ll r1 = bombs[src][2];
            for(int dst=0;dst<size;dst++){
                if(dst != src){
                    ll x2 = bombs[dst][0];
                    ll y2 = bombs[dst][1];
                    ll r2 = bombs[dst][2];
                    
                    ll dst_sq = (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1);
                    if(r1*r1 >= dst_sq){
                        adj[src].push_back(dst);
                    }
                }
            }
        }
        
        return adj;
    }
    
    void detonate(int i, vector<vector<int>>& adj, vector<bool>& vis){
        vis[i] = true;
        for(int j=0;j<adj[i].size();j++){
            int dst = adj[i][j];
            if(!vis[dst]){
                detonate(dst, adj, vis);
            }
        }
    }
};