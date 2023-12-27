class Solution {
    public int minInsertions(String s) {
        String reverse ="";
        for(int i =0; i<s.length(); i++) {
            reverse = s.charAt(i)+reverse+"";
        }
       int len = dp(s, reverse, s.length()-1, reverse.length()-1, new HashMap<>());
       return s.length() - len; 
    }
    
    int dp(String s, String t, int i, int j, Map<String, Integer> memo) {
        String key = i+"-"+j;
        if(i < 0 || j < 0) {
            return 0;
        }
        if(memo.containsKey(key)) {
            return memo.get(key);
        }
        if(s.charAt(i)==t.charAt(j)) {
            return 1 + dp(s, t, i - 1, j - 1, memo);
        }
        
        int result = Math.max(dp(s, t, i-1, j, memo), dp(s, t, i, j - 1, memo));
        memo.put(key, result);
        return result;
    }
}