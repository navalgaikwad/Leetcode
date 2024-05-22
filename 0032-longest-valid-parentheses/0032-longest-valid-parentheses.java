class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int ans =0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                st.push(i);
            }else {
                st.pop();
                if(!st.isEmpty()) {
                    ans = Math.max(ans, i- st.peek());
                }else {
                    st.push(i);
                }
            }
        }
        return ans;
    }
}