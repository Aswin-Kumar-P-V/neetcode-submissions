class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        posSpeed = []
        for i in range(len(speed)):
            posSpeed.append([position[i], speed[i]])
        posSpeed.sort(reverse=True)
        stack = deque()
        for pos, speed in posSpeed:
            stack.append((target - pos) / speed)
            if len(stack) >= 2 and stack[-1] <= stack[-2]:
                stack.pop()
        return len(stack)
        