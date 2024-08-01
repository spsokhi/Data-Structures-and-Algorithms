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
public:
    // DFS: just add the last element of the level to the ans
    vector<int> rightSideView(TreeNode* root) {
        vector<int>ans;
        rightTraversal(root,ans,0);
        return ans;
    }
        
private:
    void rightTraversal(TreeNode* root, vector<int>& ans, int level){
        if(root==nullptr)return;
        if(level==ans.size())
            ans.push_back(root->val);
        
        rightTraversal(root->right, ans, level+1);
        rightTraversal(root->left, ans, level+1);
    }
};