class Solution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
       
        helper(n, 0, 0, "");
        return result;
    }
    
    void helper(int n, int open, int close, String resu) {
        if(open+close == 2*n) {
            result.add(resu);
            return;
        }
        if(open < n) {
           helper(n , open + 1, close, resu+"("); 
        }  if(close < open) {
           helper(n , open, close + 1, resu+")");  
        }
    }
    
}