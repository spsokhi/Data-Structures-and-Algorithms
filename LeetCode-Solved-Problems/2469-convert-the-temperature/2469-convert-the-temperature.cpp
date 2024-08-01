class Solution {
public:
    vector<double> convertTemperature(double c) {
        double k,f;
        vector<double>ans(2);
        k=c+273.15;
        f=c*1.80+32.00;
        ans[0]=k;
        ans[1]=f;
        return ans;
    }
};