class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for(int i =0; i < s.length(); i++) {
            map.put(s.charAt(i), Math.max(i, map.getOrDefault(s.charAt(i), 0)));
        }
        int left = 0;
        int maximum =-1;
        
        for(int right =0; right < s.length(); right++) {
            maximum = Math.max(map.get(s.charAt(right)), maximum);
            if(right == maximum) {
                maximum = -1;
                result.add(right - left + 1);
                left = right + 1;
            }
        }
        return result;
    }
}