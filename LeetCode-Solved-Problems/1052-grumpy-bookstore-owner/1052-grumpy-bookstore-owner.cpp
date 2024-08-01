class Solution {
public:
    int maxSatisfied(vector<int>& customers, vector<int>& grumpy, int minutes) {
        int l=0;
        int window = 0;
        int max_window = 0;
        int satisfied = 0;
        
        for(int r=0; r<customers.size();r++){
            if(grumpy[r])
                window += customers[r];
            else
                satisfied += customers[r];
            
            if(l + r + 1 > minutes){
                if(grumpy[l])
                    window -= customers[l];
                l++;
            }
            
            max_window = max(max_window, window);
        }
        
        
        return satisfied + max_window;
    }
};