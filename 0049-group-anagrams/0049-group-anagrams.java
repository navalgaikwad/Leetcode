class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        for(String word: strs){
            char[] charArray = new char[26];
            for(char c : word.toCharArray()){
                charArray[c - 'a']++;
            }
            String str = String.join("-", String.valueOf(charArray));
            if(!map.containsKey(str)){
                map.put(str, new ArrayList<>());
            }
            map.get(str).add(word);
        }
        return new ArrayList<>(map.values());
    }
}