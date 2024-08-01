class Solution {
public:
    int minOperations(vector<string>& logs) {
        int depth = 0;
        for(int i=0; i<logs.size();i++){
            if(logs[i][0]=='.'){
                if(logs[i][1]=='.'){
                    depth--;
                    if(depth<0)depth=0;
                }
            }else{
                depth++;
            }
        }
        return depth;
    }
};