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
    bool evaluateTree(TreeNode* root) {
        // recursive DFS Postorder tarversal
        // Time: O(height), space: O(n)
        if(root->left==NULL and root->right==NULL)
            return root->val == 1;

        if(root->val == 2){
            return evaluateTree(root->left) or evaluateTree(root->right);
        }
        if(root->val == 3){
            return evaluateTree(root->left) and evaluateTree(root->right);
        }

        return true;
    }
};