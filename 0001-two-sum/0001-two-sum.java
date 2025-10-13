class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        //int sum = 0;
        //map.put(0, 0);
        for(int i=0; i<nums.length; i++) {
            //sum+=nums[i];
            if(map.containsKey(target - nums[i])) {
                int[] result = new int[2];
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            }else {
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}