class Solution:
    def longestDupSubstring(self, s: str) -> str:
        ans = ""
        j   = 1
        for i in range(len(s)):
            window = s[i:i+j]
            heystack = s[i+1:]
            while window in heystack:
                ans = window
                j += 1
                window = s[i:i+j]
        return ans