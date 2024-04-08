class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        for(String str : strs) {
            char[] count = new char[26];
            for(char c: str.toCharArray()) {
                count[c - 'a']++;
            }
            String newString = String.valueOf(count);
            if(!map.containsKey(newString)) {
                map.put(newString, new ArrayList<>());
            }
            map.get(newString).add(str);
        }
        return new ArrayList<>(map.values());
    }
}