class Solution:
    def isValid(self, s: str) -> bool:
        brackets = {
            '}' : '{',
            ']' : '[',
            ')' : '('
        }
        stack = deque()
        for char in s:
            if char in brackets and stack:
                if stack[-1] == brackets[char]:
                    stack.pop()
                else:
                    return False
            else:
                stack.append(char)
        return True if len(stack) == 0 else False