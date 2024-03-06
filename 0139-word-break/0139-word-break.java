class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return dp(s, wordDict, new HashMap<>());
    }
    
    boolean dp(String s, List<String> wordDict, HashMap<String, Boolean> memo) {
         if(memo.containsKey(s)) {
            return memo.get(s);
        }
        if(s.equals("")) {
            return true;
        }
       
        boolean flag = false;
        for(String word: wordDict) {
            if(s.startsWith(word)) {
                String slice = s.substring(word.length());
                if(dp(slice, wordDict, memo)){
                    flag = true;
                }
            }
        }
        memo.put(s, flag);
        return flag;
    }
    
}

// class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
//         return dp(s, wordDict, new HashMap<>());
//     }
    
//     boolean dp(String target, List<String> wordDict, HashMap<String, Boolean> memo) {
//         if(memo.containsKey(target)) {
//             return memo.get(target);
//         }
//         if(target == "") {
//             return true;
//         }
//         for(String word : wordDict) {
//             if(target.startsWith(word)) {
//                 String slice = target.substring(word.length());
//                 if(dp(slice, wordDict, memo)) {
//                     memo.put(target, true);
//                     return true;
//                 }
//             }
//         }
//         memo.put(target, false);
//         return false;
//     }
// }