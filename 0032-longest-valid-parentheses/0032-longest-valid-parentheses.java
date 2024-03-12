class Solution {
    public int longestValidParentheses(String s) {
        int total = 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for(int i =0; i< s.length(); i++) {
            if(s.charAt(i) == '(') {
                st.push(i);
            } else {
                st.pop();
                if(!st.isEmpty()) {
                    total = Math.max(total, i - st.peek());
                } else {
                    st.push(i);
                }
            }
        }
        return total;
    }
}