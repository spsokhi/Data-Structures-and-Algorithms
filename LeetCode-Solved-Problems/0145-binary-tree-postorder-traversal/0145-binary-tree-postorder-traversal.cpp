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
    vector<int> postorderTraversal(TreeNode* root) {
        postOrder(root);
        return ans;
    }
private:
    vector<int>ans;
    void postOrder(TreeNode* root){
        if(root==nullptr)return;
        
        postOrder(root->left);
        postOrder(root->right);
        ans.push_back(root->val);
    }
};