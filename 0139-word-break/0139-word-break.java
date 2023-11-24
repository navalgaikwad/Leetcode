import java.util.*;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return helper(s, new HashSet<>(wordDict), new HashMap<>(), 0);
    }
    
    boolean helper(String s, Set<String> wordDict, Map<Integer, Boolean> memo, int index) {
        if (memo.containsKey(index)) {
            return memo.get(index);
        }
        
        if (index == s.length()) {
            return true;
        }
        
        for (int i = index + 1; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(index, i)) && helper(s, wordDict, memo, i)) {
                memo.put(index, true);
                return true;
            }
        }
        
        memo.put(index, false);
        return false;
    }
}
