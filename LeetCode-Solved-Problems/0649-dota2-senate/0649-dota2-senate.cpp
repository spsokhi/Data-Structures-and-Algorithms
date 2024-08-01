class Solution {
public:
    string predictPartyVictory(string senate) {
        int n = senate.size();
        queue<int>rq,dq;
        for(int i=0; i<senate.size(); i++)
            senate[i] == 'R'?rq.push(i): dq.push(i);
        
        int a,b;
        while(!rq.empty() and !dq.empty()){
            a = rq.front(),b = dq.front();
            rq.pop();
            dq.pop();
            
            if(a<b)
                rq.push(a+n);
            else
                dq.push(b+n);
        }
        
        if(rq.size()>dq.size())
            return "Radiant";
        else 
            return "Dire";
    }
};