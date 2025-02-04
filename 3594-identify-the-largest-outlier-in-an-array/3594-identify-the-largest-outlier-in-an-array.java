class Solution {
    public int getLargestOutlier(int[] nums) {
        int ans = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        int sum =0;
        for(int num : nums ) {
            sum+=num;
            map.put(num*2, map.getOrDefault(num*2, 0) + 1);
        }
        for(int num : nums) {
            int t = sum - num;
            if(map.getOrDefault(t, 0) >=2 || (map.getOrDefault(t, 0) ==1 &&  t != num*2)) {
                ans = Math.max(ans, num);
            }
        }
        return ans;
    }
}