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
    // Preorder traversal
    vector<vector<int>> levelOrder(TreeNode* root) {
        buildVector(root,0);
        return ans;
    }
    
private:
    vector<vector<int>>ans;
    void buildVector(TreeNode* root, int depth){
        if(root == nullptr)return;
        if(depth==ans.size())ans.push_back(vector<int>());
        
        ans[depth].push_back(root->val);
        buildVector(root->left,depth+1);
        buildVector(root->right,depth+1);
    }
};