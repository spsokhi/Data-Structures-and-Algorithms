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
    bool isValidBST(TreeNode* root) {
        vector<int>ordered;
        InOrderTraversal(root,ordered);
        for(int i=1;i<ordered.size();i++){
            if(ordered[i]<=ordered[i-1])return false;
        }
        
        return true;
    }
    
private:
    // in-order traversal
    void InOrderTraversal(TreeNode* root, vector<int>& ordered){
        if(root == nullptr)return;
        
        InOrderTraversal(root->left,ordered);
        ordered.push_back(root->val);
        InOrderTraversal(root->right,ordered);
    }
};