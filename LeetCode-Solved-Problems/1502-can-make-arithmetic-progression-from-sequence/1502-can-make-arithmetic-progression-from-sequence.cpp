class Solution {
public:
    bool canMakeArithmeticProgression(vector<int>& arr) {
        sort(arr.begin(),arr.end());
        if(arr.size()==2)return true;
        int ref = abs(arr[1]-arr[0]);
        for(int i=2;i<arr.size();i++){
            if(abs(arr[i]-arr[i-1])!=ref)
                return false;
        }
        
        return true;
    }
};