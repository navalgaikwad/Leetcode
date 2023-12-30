class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);//add index
            }else {
               stack.pop();
                if(!stack.isEmpty()) {
                    max = Math.max(max, i - stack.peek()); //check on indiex
                }else {
                    stack.push(i);
                }
            }
        }
        return max;
    }
}