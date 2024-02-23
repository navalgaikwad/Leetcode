class Solution {
    public int minSteps(String s, String t) {
        int[] count = new int[26];
        for(char c : s.toCharArray()) {
            count[c- 'a']++;
        }
        int cnt =0;
        for(char c : t.toCharArray()) {
            if(count[c-'a'] == 0) {
                cnt++;
            }else {
                count[c-'a']--;
            }
        }
        return cnt;
    }
}
// s = "bab", t = "aba"