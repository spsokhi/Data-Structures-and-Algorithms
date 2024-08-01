class Solution {
public:
    bool checkIfExist(vector<int>& arr) {
        unordered_set<int>st;
        for(int i=0;i<arr.size();i++){
            
            if(st.find(arr[i]*2)!=st.end())return true;
            if(arr[i]%2==0 and st.find(arr[i]/2)!=st.end())return true;
            st.insert(arr[i]);
        }
        
        return false;
    }
};