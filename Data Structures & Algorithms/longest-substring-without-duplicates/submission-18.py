class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        max_length = 0
        l = 0
        sub_string = set()
        for r in range(len(s)):
            while s[r] in sub_string:
                sub_string.remove(s[l])
                l += 1
            sub_string.add(s[r])
            max_length = max(max_length, len(sub_string))
        return max_length
