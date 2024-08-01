# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        return self.calculateDepth(root,0)
        
        
        
    def calculateDepth(self, root, depth):
        if root is None:
            return depth
        return max(self.calculateDepth(root.left,depth+1),self.calculateDepth(root.right,depth+1));