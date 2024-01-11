class Solution {
    public boolean buddyStrings(String s, String goal) {
        int diff1 = -1;
        int diff2 = -1;
        if(s.length()!=goal.length()) {
            return false;
        }
        Set<Character> set = new HashSet<>();
        for(int i=0; i< s.length(); i++) {
            if(s.charAt(i)!=goal.charAt(i)) {
                if(diff1 == -1) {
                    diff1 = i;
                }else if(diff2 == -1) {
                    diff2 = i;
                }else {
                    return false;
                }
            }
            set.add(s.charAt(i));
        }
        if(diff1!=-1 && diff2!=-1) {
            return s.charAt(diff1) == goal.charAt(diff2) && 
                s.charAt(diff2) == goal.charAt(diff1);
        }
        if(diff1!=-1) return false;
        return set.size() < goal.length();
    }
}