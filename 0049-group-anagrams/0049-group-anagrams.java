class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, ArrayList<String>> map = new HashMap<>();
        for(String wrd : strs) {
            char[] charArray = new char[26];
            for(char c : wrd.toCharArray()) {
                charArray[c - 'a']++;
            }
            String newWord = String.valueOf(charArray);
            if(!map.containsKey(newWord)) {
                map.put(newWord, new ArrayList<>());
            }
            map.get(newWord).add(wrd);
        }
        return new ArrayList<>(map.values());
    }
}