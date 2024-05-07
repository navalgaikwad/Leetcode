class Solution {
    public int myAtoi(String s) {
        int index = 0;
        int sign = 1;
        int len = s.length();
        int total = 0;
        if(s.length() == 0) return 0;
        while(index < len && s.charAt(index) == ' ') {
            index++;
        }
         if (index == s.length()) return 0;
        if(s.charAt(index) == '-' || s.charAt(index) == '+') {
           
            sign = s.charAt(index) == '+'?1:-1;
            
            index++;
        }
        while(index < len) {
            int digit = Character.getNumericValue(s.charAt(index));
            if(digit < 0 || digit > 9) {
                break;
            }
            if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = 10* total + digit;
            index++;
        }
        return total * sign;
    }
}