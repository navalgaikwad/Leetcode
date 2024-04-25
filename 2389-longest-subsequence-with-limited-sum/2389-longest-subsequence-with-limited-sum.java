class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for(int i = 1; i<nums.length; i++) {
           prefix[i] = prefix[i-1] + nums[i]; 
        }
        int[] result = new int[queries.length];
        int i =0;
        for(int querie:queries) {
            result[i++] = helper(prefix, querie);
        }
        return result;
    }
    int helper(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        while(left <=right) {
            int mid = left + (right - left)/2;
            if(nums[mid] == target) {
                return mid + 1;
            }
            if(nums[mid] > target) {
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}