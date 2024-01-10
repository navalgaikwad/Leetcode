class Solution {
    public boolean equalFrequency(String word) {
        Map<Character, Integer> wordCounter = new HashMap<>();
        for (char c : word.toCharArray()) {
            wordCounter.put(c, wordCounter.getOrDefault(c, 0) + 1);
        }
        
        if (wordCounter.size() == 1 || wordCounter.size() == word.length()) {
            return true;
        }
        
        Map<Integer, Integer> frequencyCounter = new HashMap<>();
        for (int count : wordCounter.values()) {
            frequencyCounter.put(count, frequencyCounter.getOrDefault(count, 0) + 1);
        }
        
        if (frequencyCounter.size() != 2) {
            return false;
        }
        
        int maxCount = Collections.max(frequencyCounter.keySet());
        int minCount = Collections.min(frequencyCounter.keySet());
        
        return (minCount == 1 && frequencyCounter.get(minCount) == 1) ||
               (maxCount - minCount == 1 && frequencyCounter.get(maxCount) == 1);
    }
}
