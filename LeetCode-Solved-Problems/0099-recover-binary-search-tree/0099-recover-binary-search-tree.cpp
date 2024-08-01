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
    void recoverTree(TreeNode* root) {
        if(root == nullptr)return;
        
        inOrder(root);
        
        // now swap the two wrong nodes
        swap(first->val,second->val);
    }
    
private:
    TreeNode* first, *second, *prev;
    void inOrder(TreeNode* root){
        if(root == nullptr)return;
        
        inOrder(root->left);
        
        if(prev!=nullptr && root->val < prev->val){
            if(first==nullptr)
                first=prev;
            second=root;
        }
        prev = root;
        
        inOrder(root->right);
    }
    
};