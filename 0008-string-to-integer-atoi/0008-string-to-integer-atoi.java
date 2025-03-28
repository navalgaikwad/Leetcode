class Solution {
    public int myAtoi(String s) {
        int index = 0;
        while(index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
         if(index == s.length()) return 0;
        int sign = 1;
        if(s.charAt(index) == '+' || s.charAt(index) == '-') {
            sign = s.charAt(index) == '+' ? 1 : -1;
            index++;
        }
        int total = 0;

        while(index < s.length()) {
            if(s.charAt(index) < '0' || s.charAt(index) > '9') {
                break;
            }
            if(Integer.MAX_VALUE/10 < total || 
               Integer.MAX_VALUE/10 == total && 
               Integer.MAX_VALUE%10 < s.charAt(index) - '0') {
                return sign == 1 ? Integer.MAX_VALUE:Integer.MIN_VALUE; 
            }
            total = total * 10 + s.charAt(index) - '0';
            index++;
        }
        return total * sign;
    }
}