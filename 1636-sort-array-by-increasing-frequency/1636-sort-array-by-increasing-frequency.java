class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Integer> pq = 
            new PriorityQueue<>((a, b)-> map.get(a)  == map.get(b) ? b -a : map.get(a) -map.get(b));
        pq.addAll(map.keySet());
        int[] result = new int[nums.length];
        int k=0;
        while(!pq.isEmpty()){
            int element = pq.remove();
            for(int i=0; i<map.get(element); i++) {
                result[k++] = element;
            }
        }
        return result;
    }
}