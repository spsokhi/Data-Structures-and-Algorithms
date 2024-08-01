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
    vector<int>vals;
    bool isEvenOddTree(TreeNode* root, size_t l=0) {
        if(root == NULL)
            return true;
        if(root->val % 2 == l%2)
            return false;
        vals.resize(max(vals.size(), l+1));
        if(vals[l] != 0 and ((l%2 && vals[l] <= root->val) || (!(l%2) && vals[l]>= root->val)))
            return false;   
        vals[l] = root->val;
        return isEvenOddTree(root->left, l+1) && isEvenOddTree(root->right, l+1);
    }
};