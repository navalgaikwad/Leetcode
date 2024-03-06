class Solution {
    public String customSortString(String order, String s) {
        String a = "";
        String b = "";
        int[] arr = new int[26];
        for(char c : order.toCharArray()) {
            arr[c - 'a']++;
        }
        
        for(char c : s.toCharArray()) {
            if(arr[c - 'a'] == 0) {
                a+=c;
            }else {
                arr[c - 'a']++;
            }
        }
        for(char c : order.toCharArray()) {
            while(arr[c- 'a']>1) {//here count is 2 because we have traverse it on both order and s
                b+=c;
                arr[c- 'a']--;
            }
        }
        return b+a;
    }
}