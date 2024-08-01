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
    int findBottomLeftValue(TreeNode* root) {
        vector<int>leftNodes;
        queue<TreeNode*>bfsQ;
        bfsQ.push(root);
        
        while(!bfsQ.empty()){
            int size = bfsQ.size();
            for(int i=0;i<size;i++){
                TreeNode* cur = bfsQ.front();
                bfsQ.pop();
                if(i==0)leftNodes.push_back(cur->val);
                if(cur->left)bfsQ.push(cur->left);
                if(cur->right)bfsQ.push(cur->right);
            }
        }
        
        return leftNodes[leftNodes.size()-1];
    }
};