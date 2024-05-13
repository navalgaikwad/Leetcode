class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i<nums.length -2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if(sum == 0) {
                    result.add(Arrays.asList(nums[left], nums[right], nums[i]));
                    while(left < right && nums[left] == nums[left+1]) {
                        left = left  +1;
                    }
                    while(left < right && nums[right] == nums[right-1]) {
                        right = right  -1;
                    }
                    left++;
                    right--;
                }else if(sum < 0) {
                    left++;
                }else if(sum > 0){
                    right--;
                }
            }
            while( i + 1 < nums.length && nums[i] == nums[i+1]) {
                i = i + 1;
            }
        }
        return result;
    }
}