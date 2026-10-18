class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        operators = set(["+", "-", "*", "/"])
        stack = deque()
        for token in tokens:
            if token not in operators:
                stack.append(int(token))
            elif token == "+":
                b = stack.pop()
                a = stack.pop()
                stack.append(a+b)
            elif token == "-":
                b = stack.pop()
                a = stack.pop()
                stack.append(a-b)
            elif token == "*":
                b = stack.pop()
                a = stack.pop()
                stack.append(a*b)
            elif token == "/":
                b = stack.pop()
                a = stack.pop()
                stack.append(int(a/b))
        return stack.pop()
        