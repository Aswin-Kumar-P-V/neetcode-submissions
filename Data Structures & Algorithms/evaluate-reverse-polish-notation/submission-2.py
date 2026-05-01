class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        operators = {'+', '-', '*',  '/'}
        stack = []
        for char in tokens:
            if char in operators:
                a = stack.pop()
                b = stack.pop()
                if char == '+':
                    stack.append(b + a)
                elif char == '-':
                    stack.append(b - a)
                elif char == '*':
                    stack.append(a * b)
                else:
                    stack.append(int(b / a))
            else:
                stack.append(int(char))
        return stack.pop()
