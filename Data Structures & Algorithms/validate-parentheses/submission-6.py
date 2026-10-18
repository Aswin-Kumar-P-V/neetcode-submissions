class Solution:
    def isValid(self, s: str) -> bool:
        parMap = {
            ']' : '[',
            '}' : '{',
            ')' : '('
        }
        stack = deque()
        for char in s:
            if char in parMap:
                if stack and stack[-1] == parMap[char]:
                    stack.pop()
                else:
                    return False
            else:
                stack.append(char)
        return len(stack) == 0