public class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int counter = t.length(), begin = 0, end = 0;
        int minLen = Integer.MAX_VALUE, head = 0;
        while (end < s.length()) {
            int count = map[s.charAt(end)]--;
            end++;
            if (count > 0) {
                counter--;
            }
            while (counter == 0) {
                if (end - begin < minLen) {
                    minLen = end - begin;
                    head = begin;
                }
                int beginCount = map[s.charAt(begin)]++;
                begin++;
                if (beginCount == 0) {
                    counter++;
                }
            }
            
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(head, head + minLen);
    }
}
