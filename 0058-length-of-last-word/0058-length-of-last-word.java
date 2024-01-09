class Solution {
    public int lengthOfLastWord(String s) {
        String[] st = s.split(" ");
        return st[st.length-1].length();
    }
}