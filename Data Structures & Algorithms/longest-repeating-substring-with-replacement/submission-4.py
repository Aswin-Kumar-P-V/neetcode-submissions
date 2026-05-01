class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        map = {}
        max_freq = 0
        l = 0
        res = 0
        for r in range(len(s)):
            map[s[r]] = 1 + map.get(s[r], 0)
            max_freq = max(max_freq, map[s[r]])
            while r - l + 1 - max_freq > k : 
                map[s[l]] = map[s[l]] - 1
                l += 1
            res = r - l + 1
        return res