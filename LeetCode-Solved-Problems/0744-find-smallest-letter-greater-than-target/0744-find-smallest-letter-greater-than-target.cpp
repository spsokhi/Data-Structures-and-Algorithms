class Solution {
public:
    char nextGreatestLetter(vector<char>& letters, char target) {
        auto upper = upper_bound(letters.begin(),letters.end(),target);
        
        return upper==letters.end()?letters[0]:*upper;
    }
};