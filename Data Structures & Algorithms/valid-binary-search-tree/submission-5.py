# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        res = []
        def inorder_dfs(root):
            if not root:
                return
            inorder_dfs(root.left)
            res.append(root.val)
            inorder_dfs(root.right)
        inorder_dfs(root)
        for i in range(1, len(res)):
            if res[i] <= res[i-1]:
                return False
        return True