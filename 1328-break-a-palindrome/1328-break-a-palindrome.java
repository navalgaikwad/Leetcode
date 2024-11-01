class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length() <= 1) return "";
        int left =0, right = palindrome.length() - 1;
        char[] c = palindrome.toCharArray();
        while(left < right) {
            if(c[left] != 'a') {
                c[left] = 'a';
                return String.valueOf(c);
            }else {
                left++;
                right--;
            }
        }
        c[palindrome.length() - 1] = 'b';
        return String.valueOf(c); 
    }
}