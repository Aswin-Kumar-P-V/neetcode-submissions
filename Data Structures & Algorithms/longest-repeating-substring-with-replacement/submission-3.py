class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        l = res = max_f = 0
        map = {}

        for r in range(len(s)):
            map[s[r]] = 1 + map.get(s[r], 0)
            max_f = max(max_f, map[s[r]])

            while (r - l - max_f) + 1 > k:
                map[s[l]] -= 1
                l += 1
            
            res = max(res, r - l + 1)
        
        return res