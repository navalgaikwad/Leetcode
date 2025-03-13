class Solution {
    public boolean rotateString(String s, String goal) {
        // Check if lengths are equal
        if (s.length() != goal.length()) {
            return false;
        }
        
        // Concatenate s with itself and check if goal is a substring
        String comb = s + s;
        return comb.contains(goal);
    }
}