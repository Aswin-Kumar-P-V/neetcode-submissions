class MinStack:

    def __init__(self):
        self.minstack = []
        self.min = 0

    def push(self, val: int) -> None:
        if not self.minstack:
            self.minstack.append(0)
            self.min = val
        else:
            diff = val - self.min
            self.minstack.append(diff)
            self.min = val if diff < 0 else self.min

    def pop(self) -> None:
        if not self.minstack:
            return 
        top_el = self.minstack.pop()
        if top_el < 0:
            self.min = self.min - top_el

    def top(self) -> int:
        top_el = self.minstack[-1]
        return self.min if top_el < 0 else top_el + self.min
        

    def getMin(self) -> int:
        return self.min

[0,-3]
4,1