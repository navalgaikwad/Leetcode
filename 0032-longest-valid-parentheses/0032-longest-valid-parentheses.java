class Solution {
    //missing parenthesise current size - total length
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int ans =0;
        st.push(-1);//add -1 default
        for(int i =0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                st.push(i);
            }else {
                st.pop();
                if(!st.isEmpty()) {
                    ans = Math.max(ans, i - st.peek());
                }else {
                    st.push(i);
                }
            }
        }
        return ans;
    }
}
