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
    int kthSmallest(TreeNode* root, int k) {
        vector<int>ordered;
        inOrderTraversal(root, ordered);
        return ordered[k-1];
    }
    
private:
    void inOrderTraversal(TreeNode* root, vector<int>& ordered){
        if(root==nullptr)return;
        
        inOrderTraversal(root->left, ordered);
        ordered.push_back(root->val);
        inOrderTraversal(root->right, ordered);
    }
};