class Solution {
    //same template of valid parenthesies
    public String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack<>();
        //st.push('\0');
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                if(!st.isEmpty()) {
                    sb.append('(');
                }
                st.push('(');
            }else {
                st.pop();
                if(!st.isEmpty()) {
                    sb.append(')');
                }
            }
        }
        return sb.toString();
    }
}