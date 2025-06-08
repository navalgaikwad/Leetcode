class Solution {
    public int getLargestOutlier(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            sum+=num;
            map.put(num*2, map.getOrDefault(num*2, 0 ) + 1);
        }
        for(int num : nums) {
            if(map.getOrDefault(sum - num, 0) >= 2 || (map.getOrDefault(sum - num, 0) == 1 && sum - num != 2*num)) {
                ans = Math.max(ans, num);
            }
        }
        return ans;
    }
}