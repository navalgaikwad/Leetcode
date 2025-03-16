import java.util.*;

class Solution {
    // HashMap to store nodes at each vertical index
    HashMap<Integer, List<int[]>> map = new HashMap<>();
    int minCol = 0, maxCol = 0;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Perform DFS to store nodes with (row, value) in map
        dfs(root, 0, 0);

        // Iterate from minCol to maxCol and sort each list based on row and value
        for (int i = minCol; i <= maxCol; i++) {
            List<int[]> list = map.get(i);
            if (list != null) {
                Collections.sort(list, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
                List<Integer> current = new ArrayList<>();
                for (int[] num : list) {
                    current.add(num[1]);
                }
                result.add(current);
            }
        }
        return result;
    }

    void dfs(TreeNode root, int index, int dept) {
        if (root == null) return;

        // Track min and max column indices for ordering later
        minCol = Math.min(minCol, index);
        maxCol = Math.max(maxCol, index);

        // Add node's value to the map at the corresponding column index
        map.putIfAbsent(index, new ArrayList<>());
        map.get(index).add(new int[]{dept, root.val});

        // DFS for left and right subtrees
        dfs(root.left, index - 1, dept + 1);
        dfs(root.right, index + 1, dept + 1);
    }
}
