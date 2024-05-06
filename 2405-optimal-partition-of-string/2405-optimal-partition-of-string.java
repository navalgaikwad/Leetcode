class Solution {
    public int partitionString(String s) {
        Set<Character> set = new HashSet<>();
        int result = 1;
        for(char c : s.toCharArray()) {
            if(set.contains(c)) {
                result++;
                set = new HashSet<>();
            }
            set.add(c);
        }
        return result;
    }
}