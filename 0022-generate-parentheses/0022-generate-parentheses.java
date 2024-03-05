class Solution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        helper(n, 0, 0, "");
        return result;
    }
    
    void helper(int n, int open, int close, String res) {
        if(open+close == n*2) {
            result.add(res);
            return;
        }
        if(open < n) {
            helper(n, open+1, close, res+"(");
        }
        if(close < open) {
            helper(n, open, close+1, res+")");
        }
    }
}