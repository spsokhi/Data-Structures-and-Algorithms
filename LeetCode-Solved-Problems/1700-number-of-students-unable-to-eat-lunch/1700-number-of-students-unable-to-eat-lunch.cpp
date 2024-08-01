class Solution {
public:
    int countStudents(vector<int>& students, vector<int>& sandwiches) {
        int j=0;
        int z=0,one=0;
        for(int n:students)
            n==0?z++:one++;
        
        while(j<sandwiches.size()){
            if(sandwiches[j++]==0)z--;
            else one--;
            
            if(z<0 or one<0)return max(z, one);
        }
        return 0;
    }
};