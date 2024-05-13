class Solution {
    public int myAtoi(String s) {
        int sign = 1;
        int index =0;
        int number =0;
        if(s.length() == 0) {
            return 0;
        }
        while(index < s.length() && s.charAt(index)==' ') {
            index++;
        }
        if(s.length() == index) {
            return 0;
        }
        if(s.charAt(index) =='-' || s.charAt(index) == '+') {
            sign = s.charAt(index) =='-' ? -1 : 1;
            index++;
        }
        while(index < s.length()) {
            int c = s.charAt(index) -'0';
            
            if( c < 0 || c > 9) {
                break;
            }
            if(Integer.MAX_VALUE/10 < number || 
               Integer.MAX_VALUE/10 == number && 
               Integer.MAX_VALUE%10 < c) {
                return sign == 1 ? Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            number = number*10 + c;
            index++;
        }
        return number*sign;
    }
}