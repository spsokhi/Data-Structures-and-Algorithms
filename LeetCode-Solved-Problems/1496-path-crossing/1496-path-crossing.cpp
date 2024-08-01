class Solution {
public:
    
    bool isPathCrossing(string path) {
        unordered_map<char, pair<int, int>> moves;
        moves['N'] = {0, 1};
        moves['S'] = {0, -1};
        moves['W'] = {-1, 0};
        moves['E'] = {1, 0}; 
        
        set<string>st;
        st.insert("0,0");
        
        int x=0,y=0;
        
        for(char ch:path){
            pair<int,int> currMove = moves[ch];
            int dx = currMove.first;
            int dy = currMove.second;
            
            x+=dx;
            y+=dy;
            
            string newPoint = to_string(x)+","+to_string(y);
            
            if(st.find(newPoint)!=st.end())return true;
            st.insert(newPoint);
        }
        
        
        return false;
    }

};