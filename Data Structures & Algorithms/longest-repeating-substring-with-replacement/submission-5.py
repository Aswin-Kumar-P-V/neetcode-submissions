class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        char_map = defaultdict(int)
        longest = l = maxf = 0
        for r in range(len(s)):
            char_map[s[r]] += 1
            maxf = max(maxf, char_map[s[r]]) 
            while (r-l + 1) - maxf > k:
                char_map[s[l]] -= 1
                l += 1
            longest = max(longest, r-l + 1)
        return longest

        