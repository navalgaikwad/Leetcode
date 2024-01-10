class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int max =0;
        st.push(-1);
        for(int i=0;i<s.length(); i++) {
            if(s.charAt(i)=='(') {
                st.push(i);
            }else {
                st.pop();
                if(!st.isEmpty()) {
                    max = Math.max(max, i - st.peek());
                }else {
                    st.push(i);
                }
            }
        }
        return max;
    }
}