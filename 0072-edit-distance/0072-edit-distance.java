public class Solution {

    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] memo = new int[len1][len2];
        for (int i = 0; i < len1; i++) {
            Arrays.fill(memo[i], -1);
        }
        return minDistanceHelper(word1, word2, len1 - 1, len2 - 1, memo);
    }

    private int minDistanceHelper(String word1, String word2, int i, int j, int[][] memo) {
        if (i < 0) return j + 1;
        if (j < 0) return i + 1;

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            memo[i][j] = minDistanceHelper(word1, word2, i - 1, j - 1, memo);
        } else {
            int insert = minDistanceHelper(word1, word2, i, j - 1, memo);
            int delete = minDistanceHelper(word1, word2, i - 1, j, memo);
            int replace = minDistanceHelper(word1, word2, i - 1, j - 1, memo);
            memo[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
        }
        return memo[i][j];
    }
}
