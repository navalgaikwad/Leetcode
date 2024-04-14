class Solution {
    public int minDeletions(String s) {
        int[] count = new int[26];
        HashSet<Integer> set = new HashSet<>();
        for(char c : s.toCharArray()) {
           // map.put(c, map.getOrDefault(c, 0 ) + 1);
            count[c -'a']++;
        }
        
        int deletation = 0;
        for(int freq : count) {
            while(freq > 0 && set.contains(freq)) {
                freq--;
                deletation++;
            }
            set.add(freq);
        }
        return deletation;
    }
}