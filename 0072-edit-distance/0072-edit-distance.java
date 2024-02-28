class Solution {
    public int minDistance(String word1, String word2) {
        //int[][] dp = new int[][];
        return dfs(word1, word2, word1.length()-1, word2.length()-1, new HashMap<>());
    }
    
    int dfs(String word1, String word2, int i, int j, HashMap<String, Integer> memo) {
        String key = i+"-"+j;
        
        if(i < 0) {
            return j+1; // Insert all characters from word2
        }
        if(j < 0) {
          return i+1;   // Delete all characters from word1
        }
        if(memo.containsKey(key)) {
            return memo.get(key);
        }
        //if both are same
        //insert
        //delete
        //replace
        int value;
        if(word1.charAt(i) == word2.charAt(j)) {
            value = dfs(word1, word2, i - 1, j - 1, memo);
        }else {
            int insert = dfs(word1, word2, i - 1, j, memo);
            int delete = dfs(word1, word2, i, j - 1, memo);
            int replace = dfs(word1, word2, i - 1, j - 1, memo);
            value =  1 + Math.min(insert, Math.min(delete, replace));
        }
        memo.put(key, value);
        return value;
    }
}

//Input: word1 = "horse", word2 = "ros"
//Output: 3

//"horse", word2 = "ros"
//h = r
//rorse
//rorse
//rosse
//rose
//ros
