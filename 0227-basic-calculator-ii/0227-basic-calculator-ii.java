class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int currentNo =0;
        char sign = '+';
        
        for(int i=0; i<s.length(); i++) {
            if(Character.isDigit(s.charAt(i))) {
                currentNo = (currentNo *10) + (s.charAt(i) - '0');
            }
            //if(!Character.isDigit(c) && !Character.isWhitespace(c) || i == s.length() - 1) {
            if(!Character.isDigit(s.charAt(i)) && !Character.isWhitespace(s.charAt(i)) || i == s.length() - 1) {
                if(sign == '+') {
                    stack.push(currentNo);
                }else if(sign == '-') {
                    stack.push(-currentNo);
                }else if(sign == '*') {
                    stack.push(stack.pop() * currentNo);
                }else if(sign == '/') {
                    stack.push(stack.pop() / currentNo);
                }
                sign = s.charAt(i);
                currentNo =0;  
            }
            
        }
        int result =0;
        while(!stack.isEmpty()) {
            result+=stack.pop();
        }
        return result;
    }
}