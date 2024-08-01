class Solution {
public:
    int trap(vector<int>& height) {
        // two pointers 
        // trappedWater at each position = min(maxLeft,maxRight) - height[i]
        if(!height.size())return 0;
        
        
        int l=0 , r=height.size()-1;
        int maxLeft=height[l] , maxRight=height[r];
        int ans=0;
        
        while(l<r){
            if(maxLeft < maxRight){
                l++;
                maxLeft = max(maxLeft,height[l]);
                ans+= maxLeft - height[l];
            }
            else{
                r--;
                maxRight = max(maxRight,height[r]);
                ans+= maxRight - height[r];
            }
        }
        
        
        return ans;
    }
};