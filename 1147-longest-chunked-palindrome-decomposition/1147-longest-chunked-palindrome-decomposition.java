class Solution {
    //start from first and end
    //
    //ghiabcdefhelloadamhelloabcdefghi
    //l =ghi  r = ghi
    //if equals l == r increamnet count
    public int longestDecomposition(String S) {
        int res = 0, n = S.length();
        String l ="", r ="";
        for(int i = 0; i<n; i++) {
            l = l + S.charAt(i);
            r = S.charAt(n - i - 1) + r; 
            if(l.equals(r)) {
                res++;
                l="";
                r="";
            }
        }
        return res;
    }
}

