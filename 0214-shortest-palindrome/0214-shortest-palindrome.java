class Solution {
    public String shortestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s).reverse();
        for(int i=0; i<s.length(); i++) {
            if(s.startsWith(sb.substring(i))){
                return sb.substring(0, i) + s;
            }
        }
        return sb + s;
    }
}
//take reverse of string
//check each start with