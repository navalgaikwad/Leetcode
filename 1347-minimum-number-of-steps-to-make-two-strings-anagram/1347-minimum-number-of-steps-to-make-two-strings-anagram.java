class Solution {
    public int minSteps(String s, String t) {
        int[] count = new int[26];
        
        for(char c: s.toCharArray()) {
            count[c - 'a']++;
        }
        int cnt =0;
        for(char c: t.toCharArray()) {
            count[c- 'a']--;
            if(count[c- 'a'] < 0) {
                cnt++;
            }
        }
        return cnt;
    }
}