class Solution {
    public int calculate(String s) {
       // Stack<Character> stSign = new Stack<>();
        Stack<Integer> stNumber = new Stack<>(); //integer array
        char sign = '+';
        int number =0;
        for(int i=0; i<s.length(); i++) {
            if(Character.isDigit(s.charAt(i))) {
                
                //while(Character.isDigit(s.charAt(i)) && i < s.length()) {
                    number =number*10 +( s.charAt(i) - '0');
                    //i++;
               // }
               
            }
            char c = s.charAt(i);
            if((!Character.isWhitespace(c)&& !Character.isDigit(c))|| i == s.length() -1) {
                if(sign == '+') {
                    stNumber.push(number);
                }else if(sign == '-') {
                    stNumber.push(-number);
                }else if(sign == '*') {
                    stNumber.push(stNumber.pop() * number);
                }else if(sign == '/') {
                    stNumber.push(stNumber.pop() / number);
                }
                sign = c;
                number = 0;
            }
        }
        
        int result = 0;
        while(!stNumber.isEmpty()) {
            result+=stNumber.pop();
        }
        return result;
    }
}