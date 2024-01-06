class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        
        for(String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String st = String.valueOf(c);
            if(!map.containsKey(st)) {
                ArrayList<String> result = new ArrayList<>();
                result.add(s);
                map.put(st, result);
            }else {
                ArrayList<String> result = map.get(st);
                result.add(s);
                map.put(st, result);
            }
        }
       
       return new ArrayList(map.values());
    }
}
