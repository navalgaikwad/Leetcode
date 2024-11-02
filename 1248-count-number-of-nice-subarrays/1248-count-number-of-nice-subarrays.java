class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum =0;
        int count =0;
        map.put(0, 1);
        for(int num : nums) {
            sum+=num%2;
            if(map.containsKey(sum - k)) {
                count+=map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}