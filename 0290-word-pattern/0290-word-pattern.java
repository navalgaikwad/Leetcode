class Solution {
    public boolean wordPattern(String patterns, String s) {
        Map<Character, String> map = new HashMap<>();
        String[] arrays = s.split(" ");
        
        if(arrays.length != patterns.length())  return false;
        
        for(int i=0; i<arrays.length; i++) {
            char pattern = patterns.charAt(i);
            String word = arrays[i];
            if(map.containsKey(pattern)) {
                String value = map.get(pattern);
                if(!word.equals(value)) {
                    return false;
                }
            }else {
                if(map.containsValue(word)) {
                    return false;
                }
                map.put(pattern, word);
            }
        }
        return true;
    }
}

