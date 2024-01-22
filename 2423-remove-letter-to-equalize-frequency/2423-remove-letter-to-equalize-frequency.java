class Solution {
    public boolean equalFrequency(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: word.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        if(map.size() == 1 || word.length() == map.size()) {
            return true;
        }
        Map<Integer, Integer> freMap = new HashMap<>();
        
        for(Integer w : map.values()) {
            freMap.put(w, freMap.getOrDefault(w, 0) + 1);
        }
        
        if (freMap.size() != 2) {
            return false;
        }
        int maxCount = Collections.max(freMap.keySet());
        int minCount = Collections.min(freMap.keySet());
        return (minCount == 1 && freMap.get(minCount) == 1) || 
            (maxCount - minCount == 1 && freMap.get(maxCount) == 1);
    }
}