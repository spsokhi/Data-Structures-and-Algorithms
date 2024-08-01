# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def balanceBST(self, root: TreeNode) -> TreeNode:
        inorder = []
        
        def traverse(node):
            if not node:
                return
            
            traverse(node.left)
            inorder.append(node.val)
            traverse(node.right)
        
        traverse(root)
        N = len(inorder)
        
        def construct(left, right):
            if left>right:
                return None
            if left == right:
                return TreeNode(inorder[left])
            
            mid = (left + right) // 2
            
            current = TreeNode(inorder[mid])
            current.left = construct(left, mid - 1)
            current.right = construct(mid+1, right)
            return current
        
        return construct(0 , N-1)