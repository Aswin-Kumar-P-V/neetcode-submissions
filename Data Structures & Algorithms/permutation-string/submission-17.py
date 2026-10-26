class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s1) > len(s2):
            return False
        s1Count = [0] * 26
        s2Count = [0] * 26
        for i in range(len(s1)):
            s1Count[ord(s1[i]) - ord('a')] += 1
            s2Count[ord(s2[i]) - ord('a')] += 1
        matches = 0
        for i in range(26):
            matches += 1 if s1Count[i] == s2Count[i] else 0
        l = 0
        for r in range(len(s1), len(s2)):
            if matches == 26:
                return True
            indexL= ord(s2[l]) - ord('a')
            s2Count[indexL] -= 1
            if s2Count[indexL] == s1Count[indexL]:
                matches += 1
            elif s2Count[indexL] + 1 == s1Count[indexL]:
                matches -= 1
            indexR =  ord(s2[r]) - ord('a')
            s2Count[indexR] += 1
            if s2Count[indexR] == s1Count[indexR]:
                matches += 1
            elif s2Count[indexR] - 1 == s1Count[indexR]:
                matches -= 1
            l += 1
        return matches == 26
            