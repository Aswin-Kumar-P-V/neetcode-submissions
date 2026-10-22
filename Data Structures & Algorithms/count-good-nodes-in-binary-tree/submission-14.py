# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        res = 0
        que = deque()
        que.append((root, root.val))
        
        while que:
            node, maxval = que.popleft()
            if node.val >= maxval:
                res += 1
            if node.left:
                que.append((node.left, max(maxval, node.val)))
            if node.right:
                que.append((node.right, max(maxval, node.val)))
        return res