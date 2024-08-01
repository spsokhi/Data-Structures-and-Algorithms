class Solution {
public:
    int findTheWinner(int n, int k) {
        // time: O(n*k)
        // space: O(n) 
        queue<int>q;
        for(int i=1; i<=n; i++)q.push(i);
        
        while(q.size()>1){
            for(int i=0; i<k-1; i++){
                int element = q.front();
                q.pop();
                q.push(element);
            }
            q.pop();
        }
        
        return q.front();
    }
};