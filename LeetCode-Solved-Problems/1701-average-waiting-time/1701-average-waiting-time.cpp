class Solution {
public:
    double averageWaitingTime(vector<vector<int>>& customers) {
        // time: O(n), space:O(1)
        // Si = customers[i][0]
        // Ei = customers[i][1] 
        double total = customers[0][1];
        int S = customers[0][0] + customers[0][1];
        
        for(int i=1; i<customers.size();i++){
            int Si = customers[i][0];
            int Ei = customers[i][1];
            if(Si > S){
                total += Ei;
                S = Si + Ei;
            }
            else{
                total += (S + Ei - Si);
                S += Ei;
            }
        }
        
        return double(total/customers.size());
    }
};