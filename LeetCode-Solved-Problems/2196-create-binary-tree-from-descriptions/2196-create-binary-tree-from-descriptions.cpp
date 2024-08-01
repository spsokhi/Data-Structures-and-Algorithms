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
    TreeNode* createBinaryTree(vector<vector<int>>& descriptions) {
        map<int, TreeNode*> nodes;
        set<int> children;
        for(int i=0; i<descriptions.size(); i++){
            int parent = descriptions[i][0];
            int child = descriptions[i][1];
            int is_left = descriptions[i][2];
            
            if(nodes.find(parent) == nodes.end())
                nodes[parent] = new TreeNode(parent);
            
            if(nodes.find(child) == nodes.end())
                nodes[child] = new TreeNode(child);
            
            if(is_left) nodes[parent]->left = nodes[child];
            else nodes[parent]->right = nodes[child];
            
            children.insert(child);
        }
        
        for(int i=0; i<descriptions.size();i++){
            int parent = descriptions[i][0];
            // The root is the node without a parent
            if(children.find(parent) == children.end())
                return nodes[parent];
        }
        
        return NULL;// this is only because the return type
    }
};