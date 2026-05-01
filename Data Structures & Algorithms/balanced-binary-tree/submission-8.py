# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        is_b = True
        def dfs(root):
            nonlocal is_b
            if not root:
                return -1
            l = dfs(root.left)
            r = dfs(root.right)
            if(abs(l - r) > 1):
                is_b = False
            return 1 + max(l,r)
        dfs(root)
        return is_b
        