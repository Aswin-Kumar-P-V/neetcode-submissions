# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        self.keyIdx = {key:idx for idx, key in enumerate(inorder)}
        self.preIdx = 0
        def dfs(l, r):
            if l > r:
                return None
            root = TreeNode(preorder[self.preIdx])
            mid = self.keyIdx[preorder[self.preIdx]]
            self.preIdx += 1
            root.left = dfs(l, mid - 1)
            root.right = dfs(mid + 1, r)
            return root
        return dfs(0, len(inorder) - 1)