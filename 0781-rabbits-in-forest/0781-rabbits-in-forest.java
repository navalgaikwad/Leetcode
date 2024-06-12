class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> counts = new HashMap<>();
        int count =0;
        for(int ans : answers) {
            if(ans == 0) {
                count++;
            }else if(counts.getOrDefault(ans, 0) == 0) {
                counts.put(ans, 1);
                count+=ans + 1;
            }else {
                counts.put(ans, counts.get(ans) + 1);
                if(counts.get(ans) > ans) {
                   counts.put(ans, 0); //make it zero
                }
            }
        }
        return count;
    }
}