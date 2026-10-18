class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack = deque()
        res = [0 for i in range(len(temperatures))]
        for i, temp in enumerate(temperatures):
            while stack and temp > stack[-1][0]:
                node = stack.pop()
                res[node[1]] = i - node[1]
            stack.append([temp, i])
        return res