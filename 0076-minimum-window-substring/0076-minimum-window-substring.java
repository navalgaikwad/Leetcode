public class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int counter = t.length(), begin = 0, end = 0;
        int minLen = Integer.MAX_VALUE, head = 0;
        while (end < s.length()) {
            if (map[s.charAt(end++)]-- > 0) {
                counter--;
            }
            while (counter == 0) {
                if (end - begin < minLen) {
                    minLen = end - begin;
                    head = begin;
                }
                if (map[s.charAt(begin++)]++ == 0) {
                    counter++;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(head, head + minLen);
    }
}
