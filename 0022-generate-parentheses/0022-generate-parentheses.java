class Solution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        helper(n, 0, 0, "");
        return result;
    }
    void helper(int n, int open, int close, String ans) {
        if(2*n == open + close) {
            result.add(new String(ans));
            return;
        }
        if(open < n) {
            helper(n, open+1, close, ans+"(");
        } if(close < open) {
            helper(n, open, close+1, ans+")");
        } 
    }
}