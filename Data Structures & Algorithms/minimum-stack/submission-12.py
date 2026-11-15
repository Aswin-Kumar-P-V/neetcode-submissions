class MinStack:

    def __init__(self):
        self.min_stack = []
        self.min = 0

    def push(self, val: int) -> None:
        if not self.min_stack:
            self.min_stack.append(0)
            self.min = val
            return
        diff = val - self.min
        self.min_stack.append(diff)
        self.min = val if diff < 0 else self.min

    def pop(self) -> None:
        if not self.min_stack:
            return
        top = self.min_stack.pop()
        if top < 0:
            self.min = self.min - top

    def top(self) -> int:
        top = self.min_stack[-1]
        return top + self.min if top > 0 else self.min

    def getMin(self) -> int:
        return self.min
