class Solution {
    public int titleToNumber(String columnTitle) {
        int sum =0;
        for(char c : columnTitle.toCharArray()) {
            sum = sum *26;
            sum+= c -'A' + 1;
        }
        return sum;
    }
}