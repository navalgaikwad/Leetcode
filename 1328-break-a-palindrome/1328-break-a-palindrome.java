class Solution {
    public String breakPalindrome(String p) {
        int start =0;
        int end = p.length() - 1;
        if(p.length() <= 1) return "";
        char[] c = p.toCharArray();
        while(start < end) {
            if(c[start]!='a' ) {
                c[start] = 'a';
                return String.valueOf(c);
            }else {
                start++;
                end--;
            }
        }
        c[c.length - 1]='b';
        return String.valueOf(c);
    }
}

