class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int result = 0;
        for(int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        for(int val :map.values()) {
            if(val == 1) {
                return -1;
            }
           result += val/3;
            if(val%3 != 0) {
                result++;
            }
        }
        return result;
    }
}