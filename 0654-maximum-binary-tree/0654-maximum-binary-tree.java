class Solution {
    //[3,2,1,6,0,5]
    //[0,1,2,3,4,5]
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }
    private TreeNode dfs(int[] nums, int start, int end) {
        if(start == end) {
            return new TreeNode(nums[start]);
        }
        
        int maxIndex = start;
        for(int i = start; i <= end; i++) {
            if(nums[maxIndex] < nums[i])
                maxIndex = i;
        }
        
        TreeNode node = new TreeNode(nums[maxIndex]);
        
        if(maxIndex == start) {
            node.right = dfs(nums, maxIndex + 1, end);
        } else if(maxIndex == end) {
            node.left = dfs(nums, start, maxIndex - 1);
        } else {
            node.right = dfs(nums, maxIndex + 1, end);
            node.left = dfs(nums, start, maxIndex - 1);
        }
        return node;
    }
}