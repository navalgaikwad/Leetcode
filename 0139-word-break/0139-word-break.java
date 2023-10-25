class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return helper(s, wordDict);
    }
    
    private static boolean helper(String target, List<String> wordBank){
     int targetLength = target.length();
     boolean[] dp = new boolean[targetLength + 1];
    
     dp[0] = true;
        
     for(int i = 0; i <= targetLength; i++){
         if(dp[i]){
         for(String word :wordBank){
           if(i + word.length()<=targetLength && target.substring(i, i +word.length()).equals(word)){
               dp[i +word.length()] = true;
           }  
        }       
      }
     }
     return dp[targetLength];  
    }
}