class Solution {
    public String reverseParentheses(String s) {
        int begin = 0;
        int end;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                begin = i;
            }else if(s.charAt(i) == ')') {
                end = i;
                String temp = s.substring(begin + 1, end);
                return reverseParentheses(s.substring(0, begin) + reverse(temp) + s.substring(end + 1));
                    
            }
        }
        return s;
    }
    
    String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=s.length() - 1; i >=0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}