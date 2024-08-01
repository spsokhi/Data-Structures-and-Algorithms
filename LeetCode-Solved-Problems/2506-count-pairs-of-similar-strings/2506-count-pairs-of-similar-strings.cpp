class Solution {
public:
    int similarPairs(vector<string>& words) {
        int ans=0;
        set<char>st;
        vector<string>v;
        string temp="";
        for(int i=0;i<words.size();i++){
            for(int j=0;j<words[i].size();j++){
                st.insert(words[i][j]);
            }
            for(auto c:st)temp+=c;
            v.push_back(temp);
            st.clear();
            temp="";
        }
        for(int i=0;i<v.size();i++){
            for(int j=i+1;j<v.size();j++){
                if(v[i]==v[j])ans++;
            }
        }
        
        return ans;
    }
};