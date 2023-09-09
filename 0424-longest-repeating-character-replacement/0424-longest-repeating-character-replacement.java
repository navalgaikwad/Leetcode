class Solution {
    public int characterReplacement(String s, int k) {
    
        int n = s.length();
        int maxFreq = 0;
        int maxLen = 0;
        int start = 0;
        int[] freq = new int[26]; // Assuming lowercase English letters

        for (int end = 0; end < n; end++) {
            char currentChar = s.charAt(end);
            freq[currentChar - 'A']++; // Convert character to index (A=0, B=1, ..., Z=25)
            maxFreq = Math.max(maxFreq, freq[currentChar - 'A']);

            // Check if the current window can be expanded within the limits
            while (end - start + 1 - maxFreq > k) {
                char startChar = s.charAt(start);
                freq[startChar - 'A']--;
                start++;
            }

            // Update maxLen for the current window size
            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
      
    }
}