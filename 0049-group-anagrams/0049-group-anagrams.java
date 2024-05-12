class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        for(String str : strs) {
            char[] charArray = new char[26];
           
            for(char c: str.toCharArray()) {
                charArray[c -'a']++;
            }
            if(!map.containsKey(String.valueOf(charArray))) {
                map.put(String.valueOf(charArray), new ArrayList<>());
            }
            map.get(String.valueOf(charArray)).add(str);
        }
        return new ArrayList<>(map.values());
    }
}