class Solution {
    public String customSortString(String order, String s) {
        int[] result = new int[26];
        String a ="";
        String b ="";
        for(char c: order.toCharArray()) {
            result[c-'a']++;
        }
        
        for(char c : s.toCharArray()) {
            if(result[c-'a']==0) {
                b+=c;
            }else {
                result[c-'a']++;
            }
        }
        
        for(char c : order.toCharArray()) {
            while(result[c-'a'] > 1) {
                a+=c;
                result[c-'a']--;
            }
        }
        return a+b;
    }
}