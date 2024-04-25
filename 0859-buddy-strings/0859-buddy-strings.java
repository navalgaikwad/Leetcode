class Solution {
    public boolean buddyStrings(String s, String goal) {
        int stringDiff1 = -1;
        int stringDiff2 = -1;
        if(s.length()!=goal.length()) {
            return false;
        }
         Set<Character> set = new HashSet<>();
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) != goal.charAt(i)) {
                if(stringDiff1 == -1) {
                    stringDiff1 = i;
                }else if(stringDiff2 == -1) {
                    stringDiff2 = i;
                }else {
                    return false;
                }
            }
            set.add(s.charAt(i));
        }
        if(stringDiff1 != -1 && stringDiff2 != -1) {
         return s.charAt(stringDiff1) == goal.charAt(stringDiff2) && 
             s.charAt(stringDiff2) == goal.charAt(stringDiff1);
        }
        if(stringDiff1 != -1 || stringDiff2 != -1) {
            return false;
        }
        return set.size() < goal.length();
    }
}