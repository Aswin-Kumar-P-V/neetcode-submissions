class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s1) > len(s2):
            return False
        s1Count = [0] * 26
        s2Count = [0] * 26
        def index(ch):
            return ord(ch) - ord('a')
        for i in range(len(s1)):
            s1Count[index(s1[i])] += 1
            s2Count[index(s2[i])] += 1
        matches = 0
        for i in range(26):
            if s1Count[i] == s2Count[i]:
                matches += 1
        l = 0
        for r in range(len(s1), len(s2)):
            if matches == 26:
                return True
            idx = index(s2[r])
            s2Count[idx] += 1
            if s2Count[idx] == s1Count[idx]:
                matches += 1
            elif s2Count[idx] - 1 == s1Count[idx]:
                matches -= 1
            idx = index(s2[l])
            s2Count[idx] -= 1
            if s2Count[idx] == s1Count[idx]:
                matches += 1
            elif s2Count[idx] + 1 == s1Count[idx]:
                matches -= 1
            l += 1
        return matches == 26
 
    