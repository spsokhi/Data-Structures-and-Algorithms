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
    TreeNode* removeLeafNodes(TreeNode* root, int target) {
        // PostOrder traversal DFS
        // Time: O(n), Space: O(n)
        return traverse(root, target);
    }
    
    TreeNode* traverse(TreeNode* node, int target){
        if(node==NULL)return NULL;
        
        node->left = traverse(node->left, target);
        node->right = traverse(node->right, target);
        
        if(node->left==NULL and node->right==NULL and node->val==target){
            return NULL;
        }
        
        return node;
    }
};