class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length() <= 1) return "";
        char[] palindromeArrray = palindrome.toCharArray();
        int left = 0;
        int right = palindrome.length()-1;
        while(left < right) {
            if(palindromeArrray[left]!='a') {
                palindromeArrray[left] = 'a';
                return String.valueOf(palindromeArrray);
            }else {
                left++;
                right--;
            }
        }
        palindromeArrray[palindrome.length()-1] = 'b';
        return String.valueOf(palindromeArrray);
    }
}