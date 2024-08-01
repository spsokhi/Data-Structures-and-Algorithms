class Solution {
public:
    int countPoints(string rings) {
        vector<set<char>>v(10);
        for(int i=0;i<rings.size();i+=2){
            v[rings[i+1]-'0'].insert(rings[i]);
        }
        int ans=0;
        for(auto it:v)
            ans+= it.size()==3;
        
        
        return ans;
    }
};