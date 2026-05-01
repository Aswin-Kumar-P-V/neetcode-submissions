class Solution:
    def isValid(self, s: str) -> bool:
        map = {
            ')' : '(',
            '}' : '{',
            ']' : '['
        }
        l = []
        for char in s:
            if char in map:
                if l and map[char] == l[-1]:
                    l.pop()
                else:
                    return False
            else:
                l.append(char)
        return not l