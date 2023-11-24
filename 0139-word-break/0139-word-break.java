class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return helper(s, wordDict, new HashMap<>());
    }
    
    boolean helper(String s, List<String> wordDict, Map<String, Boolean> memo) {
        if(memo.containsKey(s)) return memo.get(s);
        if(s.isEmpty()){
            return true;
        }
        
        for(String word: wordDict){
            if(s.startsWith(word)){
               if(helper(s.substring(word.length()), wordDict, memo)) {
                   memo.put(s, true);
                   return true;
               } 
            }
        }
        memo.put(s, false);
        return false;
    }
}