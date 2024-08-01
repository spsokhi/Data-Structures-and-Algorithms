class Solution {
public:
    vector<int> sequentialDigits(int low, int high) {
        vector<int>ans;
        int low_digits = numberOfDigits(low);
        int high_digits = numberOfDigits(high);
        
        for(int digits = low_digits; digits < high_digits+1; digits++){
            for(int start=1; start<9; start++){
                if(start+ digits > 10)break;
                
                int num = start;
                int prev = start;
                
                for(int i=0; i< digits-1; i++){
                    num *= 10;
                    prev += 1;
                    num += prev;
                }
                
                if(num >= low and num <= high)
                    ans.push_back(num);
            }
        }
        
        return ans;
    }
    
private:
    int numberOfDigits(int number) { // return the number of digits in an integer (like the size of it)
        return int(log10(number) + 1);
    }
};