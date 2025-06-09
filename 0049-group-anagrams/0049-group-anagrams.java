class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            char[] c = str.toCharArray();
            char[] array = new char[26];
            for(char a: c) {
                array[a -'a']++;
            }
            String val = String.valueOf(array);
            map.putIfAbsent(val, new ArrayList<>());
            map.get(val).add(str);
        }

        List<List<String>> result = new ArrayList<>();
       result.addAll(map.values());
       return result;
    }
}