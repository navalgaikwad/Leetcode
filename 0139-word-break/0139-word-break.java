class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return helper(s, wordDict, new HashMap<>());
    }
    boolean helper(String s, List<String> wordDict, Map<String, Boolean> memo) {
        if(s.equals("")) {
            return true;
        }
        if(memo.containsKey(s)) {
            return memo.get(s);
        }
        boolean flag = false;
        for(String word : wordDict) {
            if(s.startsWith(word)) {
                String remainder = s.substring(word.length());
                if(helper(remainder, wordDict, memo)) {
                   
                    flag = true;
                }
            }
        }
        memo.put(s, flag);
        return flag;
    }

}

// O(n * k * l)