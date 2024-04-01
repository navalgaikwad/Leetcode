class Solution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        helper(n, 0, 0, "");
        return result;
    }
    void helper(int n, int open, int close, String ans) {
        if(2*n == open+close) {
            result.add(new String(ans));
            return;
        }
        if(open < n) {
           helper(n, open + 1, close, ans+"("); 
        }
        if(close < open) {
           helper(n, open, close + 1, ans+")"); 
        }
    }
}
/*
The number of nodes in a full binary tree of depth 2n is 2^(2n+1) - 1, which is approximately equal to 4^n.

However, not all paths in the recursion tree are valid parentheses strings (some may violate the balance condition). The number of valid paths is the nth Catalan number, which is asymptotically bounded by 4^n / n^(3/2) or 4^n / sqrt(n).
O(4^n / sqrt(n))
*/ 