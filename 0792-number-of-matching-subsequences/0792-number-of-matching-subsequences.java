class Solution {
     //O(m * k * n)
    public int numMatchingSubseq(String s, String[] words) {
        int max = 0;
        for(String word : words) {
            if(helper(s, word)) {
                max++;
            }
        }
        return max;
    }
    
    
    boolean helper(String s, String word) {
        int index = 0;
        
       for(char c : word.toCharArray()) {
           int idx = s.indexOf(c, index);
           if(idx == -1) {
               return false;
           }
           index = idx + 1;
       }
        return true;
    }
}