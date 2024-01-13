class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int len = 0;
        int maxCount = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);

            // Update the maximum count of a character in the current window
            maxCount = Math.max(maxCount, map.get(currentChar));

            // Adjust the window size based on the allowed replacements (k)
            while (right - left + 1 - maxCount > k) {
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) - 1);
                if (map.get(s.charAt(left)) == maxCount) {
                    maxCount--;
                }
                if (map.get(s.charAt(left)) == 0) {
                    map.remove(s.charAt(left));
                }
                left++;
            }

            // Update the maximum length of the valid substring
            len = Math.max(len, right - left + 1);
        }

        return len;
    }
}
