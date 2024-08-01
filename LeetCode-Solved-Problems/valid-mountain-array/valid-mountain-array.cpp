class Solution {
public:
    bool validMountainArray(vector<int>& arr) {
        if(arr.size()<3)return false;
        
        int i=0,j=arr.size()-1;
        while(i+1<arr.size() and arr[i]<arr[i+1])i++;
        while(j>0 and arr[j]<arr[j-1])j--;
        
        return i>0 && i==j && j<arr.size()-1;
    }
};