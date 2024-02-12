class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int currentNo =0;
        char operation = '+';
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                currentNo = (currentNo * 10) + (c - '0');
            }
            
            if(!Character.isDigit(c) && !Character.isWhitespace(c) || i == s.length() - 1) {
                if(operation == '+') {
                    stack.push(currentNo);
                }else if(operation == '-') {
                    stack.push(-currentNo);
                }else if(operation == '*') {
                    stack.push(stack.pop() * currentNo);
                }else if(operation == '/') {
                    stack.push(stack.pop() / currentNo);
                }
                operation = c;
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

//"3+2*2"
//3 check for digit
//then check for operation +
//push 3 on the stcak
//operation +
//current = 2
//push  2
//3
//4