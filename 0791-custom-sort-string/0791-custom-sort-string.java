class Solution {
    public String customSortString(String od, String s) {
        String a ="";
        String b ="";
        int[] order = new int[26];
        for(char c  :od.toCharArray()) {
            order[c - 'a']++;
        }
        for(char c  :s.toCharArray()) {
            if(order[c - 'a'] == 0) {
                b+=c;
            }else {
                order[c - 'a']++;
            }
        }
        
        for(char c  :od.toCharArray()) {
            while(order[c - 'a'] > 1) {
                a+=c;
                order[c - 'a']--;
            }
        }
        return a+b;
    }
}