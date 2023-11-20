class Solution {
    public boolean checkIfPangram(String sentence) {
       Set<Character> set = new HashSet<>();
        for(char s: sentence.toCharArray()){
            set.add(s);
        }
        return set.size()==26;
    }
}