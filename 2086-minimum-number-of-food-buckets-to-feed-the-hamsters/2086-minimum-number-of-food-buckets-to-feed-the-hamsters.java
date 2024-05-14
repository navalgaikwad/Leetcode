class Solution {
    public int minimumBuckets(String s) {
        return (s.equals("H") || s.startsWith("HH") || s.endsWith("HH") || s.contains("HHH")) ?
               -1 : s.replace("H.H", "  ").length() - s.replace("H", "").length();
    }
}