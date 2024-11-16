class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i + minSize -1 < s.length(); i++) {
            map.put(s.substring(i, i + minSize), map.getOrDefault(s.substring(i, i + minSize), 0) + 1);
        }
        int result = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            Set<Character> set = new HashSet<>();
            for(char c : entry.getKey().toCharArray()) {
                set.add(c);
            }
            if(set.size() <= maxLetters) {
                result = Math.max(result, entry.getValue());
            }
        }
       // System.out.print(map);
        return result;
    }
}