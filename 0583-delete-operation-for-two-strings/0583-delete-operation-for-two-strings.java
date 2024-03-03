class Solution {
    public int minDistance(String word1, String word2) {
        return helper(word1, word2, word1.length() - 1, word2.length()- 1, new HashMap<>());
    }
    int helper(String word1, String word2, int i, int j, HashMap<String, Integer> memo) {
         String key = i+"-"+j;
        if(i < 0) {
            return j+1;
        }
        if(j < 0) {
            return i+1;
        }
        if(memo.containsKey(key)) {
            return memo.get(key);
        }
        int total = 0;
        if(word1.charAt(i) == word2.charAt(j)) {
            total = helper(word1, word2, i - 1, j - 1, memo);
        } else {
            int one = helper(word1, word2, i, j - 1, memo);
            int two = helper(word1, word2, i-1, j, memo);
             total =  1 + Math.min(one, two);
        }
        memo.put(key, total);
        return total;
    }
}