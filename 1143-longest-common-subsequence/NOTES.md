}
if(text1.charAt(i) == text2.charAt(j)) {
return 1 + dp(text1, text2, i - 1, j - 1, memo);
}
// if not matching reduce index of text1 to -1 and reduce index of text2 by -1
int result = Math.max(dp(text1, text2, i - 1, j, memo), dp(text1, text2, i, j-1, memo));
memo.put(key, result);
return result;
}
}
//https://leetcode.com/problems/longest-common-subsequence/discuss/3541424/recursion-memoization-tabulation/
​
reffer onenote
​
Conclusion
Time Complexity:  O(m⋅n)
Space Complexity:  O(m⋅n)
​
class Solution {
public int longestCommonSubsequence(String text1, String text2) {
Integer[][] memo = new Integer[text1.length()][text2.length()];
return dp(text1, text2, text1.length()-1, text2.length()-1, memo);
}
int dp(String text1, String text2, int i, int j, Integer[][] memo) {
if( i < 0 || j < 0) {
return 0;
}
if(memo[i][j] != null) {
return memo[i][j];
}
int total = 0;
if(text1.charAt(i)==text2.charAt(j)) {
return 1 + dp(text1, text2, i - 1, j - 1, memo);
}else {
int changeInTextOne = dp(text1, text2, i - 1, j, memo);
int chnageInTextTwo = dp(text1, text2, i, j - 1, memo);
total = Math.max(changeInTextOne, chnageInTextTwo);
}
memo[i][j] = total;
return total;
}
}