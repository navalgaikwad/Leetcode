class Solution {
    public String customSortString(String order, String s) {
        int[] result = new int[26];
        for(char c: order.toCharArray()) {
            result[c - 'a']++;
        }
        String a="";
        String b="";
        for(char c: s.toCharArray()) {
            if(result[c- 'a'] == 0) {
                a+=c;
            }else {
               result[c- 'a']++; 
            }
        }
        for(char c: order.toCharArray()) {
            while(result[c- 'a']>1) {//here count is 2 because we have traverse it on both order and s
                b+=c;
                result[c- 'a']--;
            }
        }
        return b+a;
    }
}
//order = "cba", s = "abcd"
//i will take the array of 26
//get the count order than s
// from count whose element is 0 we will get unorder character