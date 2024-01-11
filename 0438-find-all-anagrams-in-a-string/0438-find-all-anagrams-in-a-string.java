import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> table = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for (char c : p.toCharArray()) {
            table.put(c, table.getOrDefault(c, 0) + 1);
        }

        if (s.length() < p.length() || s.length() == 0) {
            return ans;
        }

        int begin = 0, end = 0, wordSize = p.length();
        int counter = table.size();

        while (end < s.length()) {
            char endChar = s.charAt(end);

            if (table.containsKey(endChar)) {
                table.put(endChar, table.get(endChar) - 1);
                if (table.get(endChar) == 0) counter--;
            }

            end++;

            while (counter == 0) {
                if (end - begin == wordSize) {
                    ans.add(begin);
                }

                char beginChar = s.charAt(begin);

                if (table.containsKey(beginChar)) {
                    table.put(beginChar, table.get(beginChar) + 1);
                    if (table.get(beginChar) > 0) counter++;
                }

                begin++;
            }
        }

        return ans;
    }
}
