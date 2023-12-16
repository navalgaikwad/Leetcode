class Solution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        helper(n, 0, 0, sb);
        return result;
    }
    
    void helper(int n, int open, int close, StringBuilder sb) {
        if(n*2 == open+close) {
            result.add(sb.toString());
            return;
        }
        if(open < n) {
           helper(n , open + 1,close, sb.append("("));
            sb.deleteCharAt(sb.length() - 1); // backtrack
        } 
        if(close < open){
           helper(n, open, close+1, sb.append(")"));
           sb.deleteCharAt(sb.length() - 1); // backtrack
        }
        
    }
}