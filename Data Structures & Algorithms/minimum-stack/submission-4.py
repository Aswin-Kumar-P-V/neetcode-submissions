class MinStack:

    def __init__(self):
        self.stack = []
        self.min = 0

    def push(self, val: int) -> None:
        if not self.stack:
            self.stack.append(0)
            self.min = val
        else:
            current = val - self.min
            if current < 0:
                self.stack.append(current)
                self.min = val
            else:
                self.stack.append(current)
        

    def pop(self) -> None:
        if not self.stack:
            return
        val = self.stack.pop()
        if val < 0:
            self.min -= val


    def top(self) -> int:
        top = self.stack[-1]
        if top < 0:
            return self.min
        else:
            return self.min + top

    def getMin(self) -> int:
        return self.min
        
