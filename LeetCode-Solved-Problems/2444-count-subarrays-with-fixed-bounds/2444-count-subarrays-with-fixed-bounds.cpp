class Solution {
public:
    int mnk,mxk;
    long long countSubarrays(vector<int>& nums, int minK, int maxK) {
        nums.push_back(1e9);
        mnk=minK;
        mxk=maxK;
        vector<int> arr;
        long long count=0;
        for(int num:nums){
            if(minK<=num and maxK>=num)arr.push_back(num);
            else{
                count += solve(arr);
                arr.clear();
            }
        }
        
        return count;
    }
    
private:
    long long solve(vector<int> &arr){
        int n = arr.size();
        long long count =0;
        int lastMin=-1, lastMax=-1;
        for(int i=0; i<n; i++){
            if(arr[i]==mnk)lastMin=i;
            if(arr[i]==mxk)lastMax=i;
            count+= min(lastMin, lastMax) +1;
        }
        
        return count;
    }
};