class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for(int i =0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
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

//
/*
(()
0
1
2


*/