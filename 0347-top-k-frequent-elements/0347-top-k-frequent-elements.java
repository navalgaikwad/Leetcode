class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        ArrayList<Integer> bucket[] = new ArrayList[nums.length + 1];
        for(int num : map.keySet()) {//vvimp
            int freq = map.get(num);
            if(bucket[freq] == null) {
               bucket[freq] = new ArrayList<>(); 
            }
            bucket[freq].add(num);
        }
        int[] res = new int[k];
        int index =0;
        for(int i = bucket.length-1; i>=0; i--) {
            if(bucket[i] != null) {
                for(int val : bucket[i]) {
                    res[index++] = val;
                    if(index == k) return res;
                }
            }
        }
        return res;
    }
}