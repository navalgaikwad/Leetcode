class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int max_Length = 0;
        String result ="";
        for(int i = 0; i < n; i++){
              int left = i;
              int right = i;
              while(left >= 0 && right<n && s.charAt(left) == s.charAt(right)){
                  if(right - left +1 >max_Length){
                      result = s.substring( left, right + 1 );
                      max_Length = ( right - left + 1);
                  }
                left--;
                right++;
              }
            
          }
    
       for(int i=0; i < n; i++){
              int left = i;
              int right = i + 1;
              while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
                  if(right - left + 1 > max_Length){
                      result = s.substring(left, right + 1);
                      max_Length = (right - left + 1);
                  }
                left--;
                right++;
              }
            
          }
     return result;
    }
}
    
    
    
 