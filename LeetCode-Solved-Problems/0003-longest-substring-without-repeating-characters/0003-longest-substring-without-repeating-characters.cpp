class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_set<char>st;
        int i=0,j=0,n=s.size(),ans=0;
        while(i<n and j<n){
            if(st.find(s[j])==st.end())//If the character is not in the set
            {
                st.insert(s[j++]);//Insert the character in set and update the j counter
                ans=max(ans,j-i);//Check if the new distance is longer than the current answer
            }
            else{
                st.erase(s[i++]);
                /*If character does exist in the set, ie. it is a repeated character, 
				we update the left side counter i, and continue with the checking for substring. */
            }
        }
        
        return ans;
    }
};