class Solution {
    public String customSortString(String order, String s) {
        int[] result = new int[26];
        for(char c : order.toCharArray()) {
            result[c - 'a']++;
        }
        
        String unorder = "";
        String orders ="";
        for(char c: s.toCharArray()) {
            if(result[c - 'a'] == 0) {
                unorder+=c;
            }else {
                result[c - 'a']++;
            }
        }
        
        for(char c: order.toCharArray()) {
            while(result[c-'a']>1) {
                orders+=c;
                result[c-'a']--;
            }
        }
        return orders+unorder;
    }
}