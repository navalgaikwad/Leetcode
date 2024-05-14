class Solution {
    public boolean checkValidString(String s) {
        int low = 0;
        int high = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') {
                low++;
                high++;
            }else if(c == ')') {
                if(low > 0) {
                    low--;
                }
                high--;
            }else {
                if(low > 0) {
                    low--;
                }
                high++;
            }
            if(high < 0) {
                return false;
            }
        }
        return low == 0;
    }
}

/*
In this code, low and high are used to keep track of the minimum and maximum possible number of open parentheses that 
could be formed by the string processed so far. 
 By incrementing high, we are essentially saying that the '*' could be part of a valid open parenthesis sequence or an empty string, so we are allowing for more open parentheses.
*/