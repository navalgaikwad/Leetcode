class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        return get(root, targetSum, map, 0L);
    }

    private int get(TreeNode root, int targetSum, Map<Long, Integer> map, long prefixSum) {
        if (root == null) {
            return 0;
        }

        prefixSum += root.val;
        int count = map.getOrDefault(prefixSum - targetSum, 0);

        map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        count += get(root.left, targetSum, map, prefixSum);
        count += get(root.right, targetSum, map, prefixSum);
        map.put(prefixSum, map.get(prefixSum) - 1);

        return count;
    }
}