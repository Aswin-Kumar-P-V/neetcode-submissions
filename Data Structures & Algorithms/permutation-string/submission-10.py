class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        s1Map = Counter(s1)
        l = 0
        for r in range(len(s1), len(s2)+1):
            s2Map = Counter(s2[l:r])
            if s1Map == s2Map:
                return True
            l += 1
        return False