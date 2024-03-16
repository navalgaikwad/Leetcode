class Solution {
    public int minDistance(String word1, String word2) {
        Integer[][] memo = new Integer[word1.length()][word2.length()];
        return helper(word1.length() - 1, word2.length() - 1, word1, word2, memo);
    }
    
    int helper(int i, int j, String word1, String word2, Integer[][] memo) {
        if(i < 0) {
            return j + 1;
        }
        if( j < 0) {
            return i + 1;
        }
        if(memo[i][j] != null) {
            return memo[i][j];
        }
        int total = 0;
        if(word1.charAt(i) == word2.charAt(j)) {
            return helper(i - 1, j - 1, word1, word2, memo);
        }else {
            int one = helper(i - 1, j, word1, word2, memo);
            int two = helper(i, j - 1, word1, word2, memo);
            
            total = 1 + Math.min(one, two);
        }
        memo[i][j] = total;
        return total;
    }
}