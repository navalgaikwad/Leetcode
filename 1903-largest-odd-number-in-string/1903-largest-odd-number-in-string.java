class Solution {
    public String largestOddNumber(String num) {
        int len = num.length();
        for(int i =len - 1; i>=0; i--) {
            if(Character.getNumericValue(num.charAt(i)) % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}