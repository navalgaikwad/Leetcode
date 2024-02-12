class Solution {
    public int sumNumbers(TreeNode root) {
        if(root==null) {
            return 0;
        }
        int totalUptilNow = 0;
        int sum = dfs(root, totalUptilNow);
        return sum;
    }
    
    private int dfs(TreeNode root, int totalUptilNow) {
        if(root==null) {
            return 0;
        }
        totalUptilNow = totalUptilNow*10+root.val;
        if(root.left==null && root.right==null) {
            return totalUptilNow;
        }
        return dfs(root.left, totalUptilNow) + dfs(root.right, totalUptilNow);
    }
    
}