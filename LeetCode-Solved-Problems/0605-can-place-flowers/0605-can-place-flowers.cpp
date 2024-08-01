class Solution {
public:
    bool canPlaceFlowers(vector<int>& flowerbed, int n) {
        if(n==0)return true;
        int size=flowerbed.size();
        for(int i=0;i<size;i++){
                if(flowerbed[i]==0 and (i==0 or flowerbed[i-1]==0) and (i==size-1 or flowerbed[i+1]==0)){
                    n-=1;
                    if(n==0)return true;
                    flowerbed[i]=1;
                }
        }
        return false;
    }
};