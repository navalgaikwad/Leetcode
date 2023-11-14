class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] results = new int[26];
        for(char c: s.toCharArray()){
            results[c - 'a' ]++;
        }
        
         int val = results[s.charAt(0) - 'a'];
        for(int result : results){
            if(result != 0 && val != result){
                return false;
            }
        }
        return true;
    }
}
