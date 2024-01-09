class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int[] count = new int[26];
       // int left =0;
        int right = s.length()-1;
        for(int left=0; left<s.length(); left++) {
          if(s.charAt(left)!=s.charAt(right)) {
              return false;
          }
            right--;
        }
        
          
        return true;
    }
}