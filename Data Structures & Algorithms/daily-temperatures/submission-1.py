class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        res = [0 for i in range(len(temperatures))]
        stack = []
        for i, temp in enumerate(temperatures):
            while stack and temp > stack[-1][0]:
                    pair = stack.pop()
                    res[pair[-1]] = i - pair[-1]
            stack.append([temp, i])
        return res