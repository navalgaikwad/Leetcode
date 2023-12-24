class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        if(pattern.length() != arr.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        for(int i = 0; i<arr.length; i++) {
            char c = pattern.charAt(i);
            String word = arr[i];
            
            if(map.containsKey(c)) {
                if(!map.get(c).equals(word)) {
                    return false;
                }
                
            }else {
                if(map.containsValue(word)) {
                    return false;
                }
                map.put(c, word);
            }
        }
        return true;
    }
}