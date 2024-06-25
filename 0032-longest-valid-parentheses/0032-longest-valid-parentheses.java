class Solution {
    public int longestValidParentheses(String s) {
        if(s.length() == 0) return 0;
        Stack<Integer> st = new Stack<>();
        int len = 0;
        st.push(-1);
        for(int i =0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                st.push(i);
            }else {
                st.pop();
                if(!st.isEmpty()) {
                    len = Math.max(len, i - st.peek());
                }else {
                    st.push(i);
                }
            }
        }
        return len;
    }
}