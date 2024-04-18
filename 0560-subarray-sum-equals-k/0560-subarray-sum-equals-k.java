class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        map.put(0, 1);
        for(Integer num : nums) {
            sum+=num;
            if(map.containsKey(sum - k)) {
                count+=map.get(sum -k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}

/*
1. two sum sarkha ahe problem ahe

*/