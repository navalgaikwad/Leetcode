class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //first me sort karnar
        //sum check karnar
        //fall hoty tar duplicte avaoid karnar
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for(int index = 0; index < len - 2; index++) {
            int left = index+1;
            int right = len - 1;
            
            while(left < right) {
                int sum = nums[index] + nums[left] + nums[right];
                if(sum == 0) {
                    result.add(new ArrayList<>(Arrays.asList(nums[index], nums[left], nums[right])));
                    while(left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while(left < right  && nums[right] == nums[right - 1]) {
                        right--; 
                    }
                left++;
                right--;
                } else if(sum < 0) {
                    left++;
                }else {
                    right--;
                }
                
            }
            while(index+1 < len && nums[index] == nums[index + 1]) {
                index++;
            }
        }
        return result;
    }
}