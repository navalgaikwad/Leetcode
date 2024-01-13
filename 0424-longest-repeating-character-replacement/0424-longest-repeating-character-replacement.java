import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int len = 0;
        int maxFreq = 0;

        // Frequency map to keep track of characters in the current window
        Map<Character, Integer> charFrequency = new HashMap<>();

        // Iterate through the string
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);

            // Update charFrequency map
            charFrequency.put(rightChar, charFrequency.getOrDefault(rightChar, 0) + 1);

            // Update max frequency
            maxFreq = Math.max(maxFreq, charFrequency.get(rightChar));

            // Calculate the number of replacements needed
            int replacementsNeeded = (right - left + 1) - maxFreq;

            // Check if replacements needed are within the allowed limit
            if (replacementsNeeded > k) {
                // Move the left pointer
                char leftChar = s.charAt(left);
                charFrequency.put(leftChar, charFrequency.get(leftChar) - 1);
                left++;
            }

            // Update the maximum length
            len = Math.max(len, right - left + 1);
        }

        return len;
    }
}
