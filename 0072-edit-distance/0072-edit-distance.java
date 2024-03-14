class Solution {
    public int minDistance(String word1, String word2) {
        return helper(word1.length()-1, word2.length()-1, word1, word2, new HashMap<>());
    }
    int helper(int i, int j, String word1, String word2, HashMap<String, Integer> memo) {
        String key = i+"-"+j;
        if(i < 0) {
            return j + 1;
        }
        if(j < 0) {
            return i + 1;
        }
        if(memo.containsKey(key)) {
            return memo.get(key);
        }
        int total = 0;
        if(word1.charAt(i) == word2.charAt(j)) {
            total = helper(i-1, j-1, word1, word2, memo);
        }else {
            int insert = helper(i-1, j, word1, word2, memo);
            int delete = helper(i, j-1, word1, word2, memo);
            int replace = helper(i-1, j-1, word1, word2, memo);
            total =1+ Math.min(insert, Math.min(delete, replace));
        }
        memo.put(key, total);
        return total;
    }
}