class Solution {
    public boolean isValidPalindrome(String s, int k) {
        int ans = lcs(s, 0, s.length()-1, new Integer[s.length()][s.length()]);
        return ans <=k;
    }
    
    int lcs(String s, int i, int j, Integer[][] memo) {
        if( j -i < 1) {
            return 0;
        }
        if(memo[i][j]!=null) {
            return memo[i][j];
        }
        if(s.charAt(i) == s.charAt(j)) {
            return lcs(s, i + 1, j - 1, memo);
        }else {
           int leftSideReduce = lcs(s, i + 1, j, memo);
           int rightSideReduce = lcs(s, i, j - 1, memo);
            int value =  1 + Math.min(leftSideReduce, rightSideReduce);
            memo[i][j] = value;
        }
        return memo[i][j];
    }
}
// class Solution {
//     public boolean isValidPalindrome(String s, int k) {
//         Integer[][] cache = new Integer[s.length()][s.length()];
//         return aux(s, 0, s.length()-1, cache) <= k;
//     }
    
//     private int aux(String s, int left, int right, Integer[][] cache) {
//         if (right - left < 1) return 0;
//         if (cache[left][right] != null) return cache[left][right];
        
//         int step = 0;
//         if (s.charAt(left) == s.charAt(right)) {
//             step = aux(s, left+1, right-1, cache);
//         } else {
//             step = 1 + Math.min(aux(s, left+1, right, cache), aux(s, left, right-1, cache));
//         }
//         cache[left][right] = step;
//         return step;
//     }
// }