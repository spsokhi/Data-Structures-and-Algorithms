/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
private:
    map<int,int>mp;
    int odd=0; // digits with odd occurence count
    int res;
    int dfs(TreeNode* curr){
        // base case 1
        if(!curr)return 0;
        
        mp[curr->val]++;
        int odd_change = mp[curr->val]&1?1:-1;
        odd += odd_change;
        
        // base case 2
        if(curr->left == NULL and curr->right == NULL){
            res = odd<=1? 1:0;
        }else{
        // recursive part
         res = dfs(curr->left) + dfs(curr->right);
        }
        odd -= odd_change; // reverse the process because we get up a level after recursion 
        mp[curr->val]--;
        return res;
    }
public:
    int pseudoPalindromicPaths (TreeNode* root) {
        return dfs(root);
    }
};