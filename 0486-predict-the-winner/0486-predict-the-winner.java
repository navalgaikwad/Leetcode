class Solution {
    public boolean predictTheWinner(int[] nums) {
        return dfs(nums, 0, nums.length - 1, new Integer[nums.length][nums.length]) >= 0;
    }
    
    int dfs(int[] nums, int i, int j, Integer[][] memo) {
        if(i == j) {
            return nums[i];
        }
        if(memo[i][j] != null) {
            return memo[i][j];
        }
        int left = nums[i] - dfs(nums, i + 1, j, memo);
        int right = nums[j] - dfs(nums, i, j - 1, memo);
        int value = Math.max(left, right);
        memo[i][j] = value;
        return value;
    }
}

// class Solution {
//     public boolean predictTheWinner(int[] nums) {
//        return dfs(nums, 0, nums.length-1)>=0;
//     }
    
//     int dfs(int[] nums, int left, int right){
//         if(left == right){
//             return nums[left];
//         }
//         int leftV=nums[left] -dfs(nums, left+1, right);
//         int rightV=nums[right] -dfs(nums, left, right-1);
        
//         return Math.max(leftV, rightV);
//     }
// }