class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        if(sum(gas)<sum(cost))return -1;
        
        int total=0;
        int startIndex=0;
        
        for(int i=0; i<gas.size();i++){
            total += gas[i]-cost[i];
            
            if(total<0){
                total=0;
                startIndex=i+1;
            }
        }
        
        return startIndex;
    }
    
private:
    int sum(vector<int>& v){
        int s=0;
        for(int i:v)s+=i;
        
        return s;
    }
};