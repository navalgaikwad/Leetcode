class Solution {
    public int minDistance(String word1, String word2) {
        return findDistance(word1, word2, word1.length()-1, word2.length()-1, new HashMap<>());
    }
    
    int findDistance(String word1, String word2, int i, int j, Map<String, Integer> memo) {
        String key = i+"-"+j;
        if( i < 0) {
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
            total = findDistance(word1, word2, i - 1, j - 1, memo);
        }else {
            int insert = findDistance(word1, word2, i - 1, j, memo);
            int delete = findDistance(word1, word2, i, j - 1, memo);
            int replace = findDistance(word1, word2, i - 1, j - 1, memo);
            total = 1+ Math.min(insert, Math.min(delete, replace));
        }
        memo.put(key, total);
        return total;
    }
}