class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        int len = 0;
        boolean isPalindromeFound = false;  // Flag to check if we found any palindrome

        for (int k = 0; k < s.length(); k++) {
            // Odd length palindromes (center is a single character)
            int left = k;
            int right = k;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > len) {
                    len = right - left + 1;
                    result = s.substring(left, right + 1);
                      // Found at least one palindrome
                }
                if (right - left + 1 > 1) {
                    isPalindromeFound = true;
                }
                left--;
                right++;
            }

            // Even length palindromes (center is between two characters)
            left = k;
            right = k + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > len) {
                    len = right - left + 1;
                    result = s.substring(left, right + 1);
                    //isPalindromeFound = true;  // Found at least one palindrome
                }
                 if (right - left + 1 > 1) {
                    isPalindromeFound = true;
                }
                left--;
                right++;
            }
        }
        // Print true/false depending on whether a palindrome was found
        System.out.println(isPalindromeFound);
        return result;
    }
}


// lowercase letter with "aabaac" return true or false 

// aabaa
// bcaabaa

// aabc

// abca
    
// a 
// a 
// b
// c
