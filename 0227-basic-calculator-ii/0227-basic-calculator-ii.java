class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int result = 0;
        int number = 0;
        char sign = '+';
        int prev = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    number = number * 10 + s.charAt(i) - '0';
                    i++;
                }
                i--;
            }
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                if (sign == '+') {
                    //st.push(number);
                    result += number;
                    prev = number;
                } else if (sign == '-') {
                   // st.push(-number);
                   result-=number;
                   prev = - number;
                } else if (sign == '*') {
                   // st.push(st.pop() * number);
                   result = result - prev + (prev * number);
                   prev = prev * number;

                } else if (sign == '/') {
                    //st.push(st.pop() / number);
                    result = result - prev + (prev / number);
                    prev = prev / number;
                }
                sign = c;
                number = 0;
            }
        }
        // // int result = 0;
        // for (int sa : st) {
        //     result += sa;
        // }
        return result;
    }
}