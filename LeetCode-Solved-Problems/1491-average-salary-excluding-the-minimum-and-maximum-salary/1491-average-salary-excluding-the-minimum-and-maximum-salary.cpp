class Solution {
public:
    double average(vector<int>& salary) {
        sort(salary.begin(),salary.end());
        double sum=0;
        for(int i=1;i<salary.size()-1;i++)
                sum+=salary[i];
        
        if(salary.size()==3)return sum;
     
        return sum/(salary.size()-2);
    }
};