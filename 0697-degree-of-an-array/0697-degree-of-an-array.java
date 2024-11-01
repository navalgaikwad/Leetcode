class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> frq = new HashMap<>();
        int degree =0;
        int res = 0;
        
        for(int i=0; i<nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            frq.putIfAbsent(nums[i], i);//putIfAbsent
            if(count.get(nums[i]) > degree) {
                degree = count.get(nums[i]);
                res = i - frq.get(nums[i]) + 1;
            }else if(count.get(nums[i]) == degree) {
                 res =  Math.min(res,  i - frq.get(nums[i]) + 1);
            }
        }
        return res;
    }
}