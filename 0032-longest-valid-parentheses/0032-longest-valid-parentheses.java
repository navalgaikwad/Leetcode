class Solution {
    public int longestValidParentheses(String s) {
        if(s.length() == 0) return 0; 
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int count =0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(' ) {
                st.push(i);
            }else {
                st.pop();
                if(!st.isEmpty()) {
                    count = Math.max(count,i - st.peek());
                }else {
                    st.push(i);
                }
            }
        }
        return count;
    }
}