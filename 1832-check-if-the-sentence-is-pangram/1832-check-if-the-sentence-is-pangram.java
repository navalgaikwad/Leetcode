class Solution {
    public boolean checkIfPangram(String s) {
        Set<Character> set = new HashSet<>();
        for(Character sne : s.toCharArray()){
           set.add(sne);
        }
        return set.size() == 26;
    }
}