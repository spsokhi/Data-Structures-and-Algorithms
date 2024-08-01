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
    TreeNode* addOneRow(TreeNode* root, int val, int depth) {
        if(depth == 1){
            TreeNode* tree = new TreeNode();
            tree->val = val;
            tree->left = root;
            return tree;
        }
        
        traverse(root,val, depth-1);
        return root;
    }
    
private:
    void traverse(TreeNode* node,int val, int depth){
        if(node==NULL)return;
        
        if(depth==1){
            TreeNode* old_left = node->left, *old_right=node->right;
            TreeNode* newLeft=new TreeNode(val);
            TreeNode* newRight=new TreeNode(val);
            newLeft->left=old_left;
            newRight->right=old_right;
            node->left=newLeft;
            node->right=newRight;
        }
        
        traverse(node->left,val, depth-1);
        traverse(node->right,val, depth-1);
    }
};