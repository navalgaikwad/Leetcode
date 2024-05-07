class Solution {
    public boolean makeEqual(String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        for(String word : words) {
            for(char c : word.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        
        int n = words.length;
        for(char c : map.keySet()) {
            int value = map.get(c);
            if(value%n != 0) {
                return false;
            }
        }
        return true;
    }
}