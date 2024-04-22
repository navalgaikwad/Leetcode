class Solution {
    public String sortString(String s) {
        int[] arr = new int[26];
        for(int i=0; i<s.length(); i++) {
            arr[s.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        while(sb.length() < s.length()) {
            for(int i = 0; i<26; i++) {
                if(arr[i] > 0) {
                    sb.append((char)('a'+i));
                    arr[i]--;
                }
            }
            for(int i = 25; i>=0; i--) {
                if(arr[i] > 0) {
                    sb.append((char)('a'+i));
                     arr[i]--;
                }
            }
        }
        return sb.toString();
    }
}