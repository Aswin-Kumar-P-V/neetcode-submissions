class Solution:
    def trap(self, height: List[int]) -> int:
        if not height:
            return 0
        res = 0
        n = len(height)
        prefix = [0 for i in range(n)]
        for i in range(1, n):
            prefix[i] = max(prefix[i-1], height[i-1])
        postfix = [0 for i in range(n)]
        for i in range(n - 2, -1,-1):
            postfix[i] = max(postfix[i + 1], height[i + 1])
        for i in range(n):
            leftmax = rightmax = height[i]
            leftmax = max(leftmax, prefix[i])
            rightmax = max(rightmax, postfix[i])
            res += min(leftmax, rightmax) - height[i]
        return res