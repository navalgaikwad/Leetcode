class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int sign = 1;
        int result = 0;
        int number = 0;
         for(int i=0; i<s.length(); i++) {
             char c = s.charAt(i);
            if(Character.isDigit(c)) {
                //while( i < s.length() && Character.isDigit(c)) {
                    number = number * 10 + Character.getNumericValue(c);
                //}
            }else if(c == '+') {
                result = result  + sign * number;
                sign = 1;
                number = 0;
            }else if(c == '-') {
                result = result  + sign * number;
                sign = -1;
                number = 0;
            }else if(c == '('){
                st.push(result);
                st.push(sign);
                result = 0;
                sign = 1;
            }else if( c == ')') {
                result = result  + sign * number;
                number = 0;
                result*=st.pop();
                result+=st.pop();
            }
        }
        if(number != 0) result += sign * number;
        return result;
    }
        
}