class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s1) > len(s2):
            return False
        s1Map = Counter(s1)
        l = 0
        s2Map = Counter(s2[l:l+len(s1)])
        for r in range(len(s1), len(s2)):
            if s1Map == s2Map:
                return True
            s2Map[s2[r]] = 1 + s2Map.get(s2[r], 0)
            s2Map[s2[l]] -= 1
            if s2Map[s2[l]] == 0:
                del s2Map[s2[l]]
            l += 1
        return s1Map == s2Map