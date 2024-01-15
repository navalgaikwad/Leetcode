class Solution {
    public String breakPalindrome(String p) {
        if(p.length() <= 1) return "";
        int left = 0; int right = p.length()-1;
        char[] c = p.toCharArray();
        while(left < right) {
            if(c[left]!='a') {
                c[left] = 'a';
                return String.valueOf(c);
            }else {
                left++;
                right--;
            }
        }
        c[p.length()-1] = 'b';
        return String.valueOf(c);
    }
}