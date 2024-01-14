class Solution {
    List<String> result = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        helper(s, 0, 0, "");
        return result;
    }
    
    void helper(String s, int part, int index, String ans) {
        if(part == 4 || index == s.length()) {
            if(part == 4 && index == s.length()) {
                result.add(ans.substring(0, ans.length() - 1));
                return;
            }
            return;
        }
        helper(s, part+1, index + 1, ans+s.charAt(index)+".");
        if(index + 2 <= s.length() && isValid(s.substring(index, index + 2))) {
           helper(s, part+1, index+2, ans+s.substring(index, index + 2)+"."); 
        }
        if(index + 3 <= s.length() && isValid(s.substring(index, index + 3))) {
           helper(s, part+1, index+3, ans+s.substring(index, index + 3) +".");   
        }
    }
    boolean isValid(String s) {
        if(s.charAt(0) == '0') return false;
        return Integer.parseInt(s) <= 255;
    }
}