class MinStack:

    def __init__(self):
        self.minstack = deque()
        self.min = deque()

    def push(self, val: int) -> None:
        self.minstack.append(val)
        if self.min:
            self.min.append(min(self.min[-1], val))
        else:
            self.min.append(val)

    def pop(self) -> None:
        self.minstack.pop()
        self.min.pop()

    def top(self) -> int:
        return self.minstack[-1]

    def getMin(self) -> int:
        return self.min[-1]