class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return helper(s, wordDict, new HashMap<>());
    }
    
    boolean helper(String s, List<String> wordDict, HashMap<String, Boolean> memo) {
        if(s.equals("")) {
            return true;
        }
        if(memo.containsKey(s)) {
            return memo.get(s);
        }
        boolean flag = false;
        for(String word : wordDict) {
            if(s.startsWith(word)) {
                String slice = s.substring(word.length());
                if(helper(slice, wordDict, memo)) {
                    flag = true;
                }
            }
        }
        memo.put(s, flag);
        return flag;
    }
}