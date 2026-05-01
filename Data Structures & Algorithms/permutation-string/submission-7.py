class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        l, r= 0, len(s1) - 1
        s1_map = defaultdict(int)
        s2_map = defaultdict(int)
        for s in s1:
            s1_map[s] += 1
        for i in range(r):
            s2_map[s2[i]] += 1
        while r < len(s2):
            s2_map[s2[r]] += 1
            if s1_map == s2_map:
                return True
            s2_map[s2[l]] -= 1
            if s2_map[s2[l]] == 0:
                del(s2_map[s2[l]])
            l += 1
            r += 1
        return False