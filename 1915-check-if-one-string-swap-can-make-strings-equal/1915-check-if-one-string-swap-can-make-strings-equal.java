class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        if(s1.equals(s2)) {
            return true;
        }
        int diff1 = -1;
        int diff2 = -1;
        for(int i=0; i<s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                if(diff1 == -1) {
                    diff1 = i;
                }else if(diff2 == -1) {
                    diff2 = i;
                }else {
                    return false;
                }
            }
        }


        return diff1!=-1 && diff2!=-1 && s1.charAt(diff1) == s2.charAt(diff2) && s1.charAt(diff2) == s2.charAt(diff1) ;
        
    }
}