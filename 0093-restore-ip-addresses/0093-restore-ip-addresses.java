class Solution {
    List<String> result = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        helper(s, 0, 0, "");
        return result;
    }
    
    void helper(String s, int index, int part, String ans) {
        if(index == s.length() || part == 4) {
            if(index == s.length() && part == 4) {
                result.add(new String(ans.substring(0, ans.length()- 1)));
            }
            return;
        }
        helper(s, index + 1, part +1, ans+s.charAt(index)+".");
        if(index + 2 <= s.length() && isValid(s.substring(index, index + 2))) {
            helper(s, index + 2, part +1, ans+s.substring(index, index + 2)+".");
        }
        if(index + 3 <= s.length() && isValid(s.substring(index, index + 3))) {
            helper(s, index + 3, part +1, ans+s.substring(index, index + 3)+".");
        }
    }
    
    boolean isValid(String num) {
        if(num.charAt(0) == '0') return false;
        return Integer.parseInt(num) <= 255;
    }
}