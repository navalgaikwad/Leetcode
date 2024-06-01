class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int number = 0;
        char sign = '+';
        for(int i=0; i<s.length(); i++) {
            if(Character.isDigit(s.charAt(i))) {
                number = number * 10 + (s.charAt(i) - '0');
                //i++;
            }
            
            if(!Character.isDigit(s.charAt(i)) && !Character.isWhitespace(s.charAt(i)) || i == s.length()-1) {
                if(sign == '+') {
                    stack.push(number);
                }else if(sign == '-') {
                    stack.push(-number);
                }else if(sign == '*') {
                    stack.push(stack.pop() * number);
                }else if(sign == '/') {
                    stack.push(stack.pop() / number);
                }
                number = 0;
                sign = s.charAt(i);
            }
        }
        int result = 0;
        while(!stack.isEmpty()) {
            result+=stack.pop();
        }
        return result;
    }
}