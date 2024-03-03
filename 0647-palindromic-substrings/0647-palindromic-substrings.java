class Solution {
    public int countSubstrings(String s) {
        int count =0;
        for(int k =0; k<s.length(); k++) {
            int i = k;
            int j =k;
            while(i>=0 && j<s.length() &&s.charAt(i)==s.charAt(j)) {
                i--;
                j++;
                count++;
            }
            i = k;
            j = k+1;
            while(i>=0 && j<s.length()&&s.charAt(i)==s.charAt(j)) {
                i--;
                j++;
                count++;
            }
        }
        return count;
    }
}