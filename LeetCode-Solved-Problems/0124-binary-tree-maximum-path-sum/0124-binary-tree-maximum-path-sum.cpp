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
    // Session #4 Trees , Code of Duty
public:
    int maxPathSum(TreeNode* root) {
        return getInfo(root).maxAns;
    }
private:
    struct Info {
        int maxPath;
        int maxAns;
        
        Info(int maxPath_, int maxAns_){
            maxPath = maxPath_;
            maxAns = maxAns_;
        }
        
        Info(){}
    };
    
    Info getInfo(TreeNode* root){
        if(root == nullptr)return Info(-1e9,-1e9);
        Info left = getInfo(root->left);
        Info right = getInfo(root->right);
        Info self;
        self.maxPath = max({root->val , root->val + left.maxPath, root->val + right.maxPath});
        self.maxAns = max({left.maxAns, right.maxAns , root->val + left.maxPath + right.maxPath, self.maxPath});
        
        return self;
    }
};