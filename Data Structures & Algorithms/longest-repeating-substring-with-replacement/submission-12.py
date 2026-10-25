class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        freq = {}
        res = l = maxfreq = 0
        for r in range(len(s)):
            char = s[r]
            freq[char] = 1 + freq.get(char, 0)
            maxfreq = max(maxfreq, freq[char])

            while ((r - l + 1) - maxfreq) > k:
                freq[s[l]] = freq[s[l]] - 1
                l += 1
            res = max(res, r - l + 1) 
        return res