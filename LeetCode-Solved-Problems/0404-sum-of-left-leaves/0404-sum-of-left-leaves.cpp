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
    int sumOfLeftLeaves(TreeNode* root) {
        return recursion(root, false);
    }
private:
    int recursion(TreeNode* node, bool left){
        if(node== NULL)return 0;
        
        if(node->left == NULL and node->right==NULL){
            if(left)return node->val;
            return 0;
        }
        
        return recursion(node->left, true)+recursion(node->right, false);
    }
};