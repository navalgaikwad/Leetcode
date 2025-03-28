class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int sign = 1;
        int result = 0;
        int number = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            }else if(c == '+') {
                result = result + sign * number;
                number = 0;
                sign = 1;
            }else if(c == '-') {
                result = result + sign * number;
                number = 0;
                sign = -1;
            }else if(c == '(') {
                st.push(result);
                st.push(sign);
                sign = 1;
                result = 0;
            }else if(c == ')') {
                result = result + sign * number;
                int sig = st.pop();
                int num = st.pop();
                result = result * sig + num;
                number = 0;
                
            }

        }
        if(number!=0)  {
            result += sign * number;
        } 
        return result;
    }
}