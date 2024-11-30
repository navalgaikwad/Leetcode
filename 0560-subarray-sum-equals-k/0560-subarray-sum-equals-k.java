class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int max = 0;
        for(int num : nums) {
            sum+=num;
            if(map.containsKey(sum- k)) {
                max +=map.get(sum - k);//vvimp
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return max;
    }
}