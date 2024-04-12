class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        for(String str : strs) {
            char[] charArray = new char[26];
            for(char c : str.toCharArray()) {
                charArray[c - 'a']++;
            }
            if(!map.containsKey(String.valueOf(charArray))) {
                map.put(String.valueOf(charArray), new ArrayList<>());
            }
            map.get(String.valueOf(charArray)).add(str);
        }
        return new ArrayList<>(map.values());
    }
}

/*
The time complexity of this algorithm is O(n * k), where n is the number of strings in strs and k is the average length of a string. This is because, for each string, we iterate through its characters to create the character array, which has a constant size (26). The space complexity is also O(n * k) due to the use of the map to store the grouped anagrams.

*/