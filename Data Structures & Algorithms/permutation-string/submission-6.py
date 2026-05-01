class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        left, right = 0, len(s1) - 1
        s1_map = defaultdict(int)
        s2_map = defaultdict(int)
        for s in s1:
            s1_map[s] += 1
        for i in range(right):
            s2_map[s2[i]] += 1
        while right < len(s2):
            s2_map[s2[right]] += 1
            if s1_map == s2_map:
                return True
            s2_map[s2[left]] -= 1
            if s2_map[s2[left]] == 0:
                del s2_map[s2[left]]
            left += 1
            right += 1
        return False