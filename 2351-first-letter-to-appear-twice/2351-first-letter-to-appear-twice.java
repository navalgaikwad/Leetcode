class Solution {
    public char repeatedCharacter(String s) {
        Set<Character> set = new HashSet<>();
        
        for(Character ch: s.toCharArray()){
            if(set.contains(ch)){
                return ch;
            }
            set.add(ch);
        }
        return '0';
    }
}