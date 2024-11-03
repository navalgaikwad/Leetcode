class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int number = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Accumulate the number if it's a digit
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            }
            
            // Process the accumulated number when encountering an operator or at the end of the string
            if ((!Character.isDigit(c) && !Character.isWhitespace(c)) || i == s.length() - 1) {
                if (sign == '+') {
                    stack.push(number);
                } else if (sign == '-') {
                    stack.push(-number);
                } else if (sign == '*') {
                    stack.push(stack.pop() * number);
                } else if (sign == '/') {
                    stack.push(stack.pop() / number);
                }
                sign = c; // Update the sign to the current operator
                number = 0; // Reset number for the next round
            }
        }

        // Sum up all values in the stack for the final result
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        
        return result;
    }
}
