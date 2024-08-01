class Solution {
public:
    // neetcode
    int leastInterval(vector<char>& tasks, int n) {
        map<char,int>mp;
        for(auto c:tasks)mp[c]++;
        
        priority_queue<int> pq;
        for(auto it:mp)pq.push(it.second);
        
        int time=0;
        queue<pair<int,int>> q;
        
        while(!pq.empty() or !q.empty()){
            time++;
            
            if(!pq.empty()){
                int cnt = pq.top() - 1;
                pq.pop();
                if(cnt){
                    q.push({cnt, time+n});
                }
            }
            
            if(!q.empty() and q.front().second == time){
                pq.push(q.front().first);
                q.pop();
            }
        }
        
        return time;
    }
};