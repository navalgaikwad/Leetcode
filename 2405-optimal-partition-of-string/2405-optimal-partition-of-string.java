class Solution {
    public int partitionString(String s) {
        HashSet<Character> set = new HashSet<>();
        int result = 1;
        for(char c : s.toCharArray()) {
            if(set.contains(c)) {
                result = result + 1;
                set = new HashSet<>(); //reset the set and add the value
                set.add(c);
            }else {
                set.add(c);
            }
        }
        return result;
    }
}

