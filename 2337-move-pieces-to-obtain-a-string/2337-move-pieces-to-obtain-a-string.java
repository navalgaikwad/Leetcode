class Solution {
    public boolean canChange(String start, String target) {
        int i =0;
        int j =0;
        int m = start.length() ;
        int n = target.length();
        while( i<start.length() && j < target.length()) {
            while(i < n &&start.charAt(i) == '_') {
                i++;
            }
            while(j < n && target.charAt(j) == '_') {
                j++;
            }
            if( i == m && j == n) {
                return true;
            }
            if( i == m || j == n) {
                return false;
            }
            if (start.charAt(i) != target.charAt(j)) return false;
            if(start.charAt(i) == 'L' && i < j) {
                return false;
            }
             if(start.charAt(i) == 'R' && i > j) {
                return false;
            }
            i++;
            j++;
        }
        while (i < n && start.charAt(i) == '_') i++;
        while (j < n && target.charAt(j) == '_') j++;
        
        return i == m && j == n;
    }
}