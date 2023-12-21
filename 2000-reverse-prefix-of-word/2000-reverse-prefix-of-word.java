class Solution {
    public String reversePrefix(String word, char ch) {
        int left = 0;
        StringBuilder sb = new StringBuilder();
        while (left < word.length()) {
            sb.append(word.charAt(left));
            if(word.charAt(left) == ch) {
                sb.reverse();
                break;
            }
            left++;
        }
        //if(left) {
          left = left+1;
          while(left < word.length()) {
              sb.append(word.charAt(left++));
          }
        //}
        return sb.toString();
    }
}