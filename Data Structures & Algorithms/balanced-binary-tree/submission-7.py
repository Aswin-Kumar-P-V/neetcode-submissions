# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        isBalance = True
        def checkBalance(root):
            nonlocal isBalance
            if not root:
                return -1
            left = checkBalance(root.left)
            right = checkBalance(root.right)
            if(abs(left-right)>1):
                isBalance=False
            return 1 + max(left, right)
        checkBalance(root)
        return isBalance
        