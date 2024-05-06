class Solution {
    public int titleToNumber(String columnTitle) {
        if(columnTitle == " ") {
            return 0;
        }
        int sum =0;
        for(Character c : columnTitle.toCharArray()) {
            sum = sum * 26;
            sum = sum + c - 'A' + 1;
        }
        return sum;
    }
}