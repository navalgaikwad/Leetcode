class Solution {
    public int myAtoi(String s) {
        int index =0;
        if(s.length() == 0) return 0;
        while(index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
        if(index == s.length()) return 0;
        
        int sign = 1;
        if(s.charAt(index)=='-' || s.charAt(index) == '+') {
            sign = s.charAt(index)=='-' ? -1: 1;
            index++;//vvimp
        }
        int total = 0;
        while(index < s.length()) {
            int number = Character.getNumericValue(s.charAt(index));
            if(number < 0 || number >9) {
                break;
            }
            if(Integer.MAX_VALUE/10 < total || 
               Integer.MAX_VALUE/10 == total && 
               Integer.MAX_VALUE%10 < number) {
                return sign == 1 ? Integer.MAX_VALUE:Integer.MIN_VALUE; 
            }
            
            total = total *10 + number;
            index++;
        }
        return total*sign;//vvimp
    }
}