class Solution {
public:
    vector<int> survivedRobotsHealths(vector<int>& positions, vector<int>& healths, string directions) {
        // my solution
        map<int,int>mp;
        // map: position -> indx
        for(int i=0; i<positions.size(); i++){
            mp[positions[i]] = i;
        }
        
        stack<int>stk; // storing positions
        for(auto it: mp){
            // it.first = stk.top() = position
            // it.second = mp[stk.top()] = indx
            
            while(!stk.empty() and  directions[mp[stk.top()]] == 'R' and directions[it.second] == 'L'){
                int curHealth = healths[it.second];
                int topHealth = healths[mp[stk.top()]];
                
                if(curHealth > topHealth){ // cur > top
                    healths[it.second]--;
                    healths[mp[stk.top()]] = 0;
                    stk.pop();
                }else if(curHealth < topHealth){ // cur < top
                    healths[mp[stk.top()]]--;
                    healths[it.second] = 0;
                    break;
                }else{ // cur == top
                    healths[it.second] = 0;
                    healths[mp[stk.top()]] = 0;
                    stk.pop();
                    break;
                }
            }
            if(healths[it.second] > 0)
                stk.push(it.first);
        }
        
        vector<int> ans;
        map<int,int>ansMap; // map: original order -> health
        for(auto it:mp){
            ansMap[it.second] = healths[it.second];
        }
        for(auto it:ansMap){
            if(it.second != 0)
                ans.push_back(it.second);
        }
        
        return ans;
    }
};