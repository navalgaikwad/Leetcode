class Solution {
    
    String getHash(String s) {//important 
        StringBuilder hashKey = new StringBuilder();
        char[] c = s.toCharArray();
        for(int i =1; i<s.length(); i++) {
            hashKey.append(((c[i] - c[i-1] + 26)%26) + 'a');
        }
        return hashKey.toString();
    }
    
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String string : strings) {
            String hashKey = getHash(string);
            if(!map.containsKey(hashKey)) {
                map.put(hashKey, new ArrayList<>());
            }
            map.get(hashKey).add(string);
        }
        List<List<String>> groups = new ArrayList<>();
        for(List<String> group: map.values()) {
            groups.add(group);
        }
        return groups;
    }
}