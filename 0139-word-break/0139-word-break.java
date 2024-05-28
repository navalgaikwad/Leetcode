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
            boolean remainder = s.startsWith(word);
            if(remainder) {
                if(helper(s.substring(word.length()), wordDict, memo)) {
                    flag = true;
                }
            }
        }
        memo.put(s, flag);
        return flag;
    }
}