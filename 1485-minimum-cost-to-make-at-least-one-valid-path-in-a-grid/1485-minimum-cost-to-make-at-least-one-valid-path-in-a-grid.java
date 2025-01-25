class Solution {
    public int minCost(int[][] grid) {
        int a = grid.length;
        int b = grid[0].length;
        Deque<int[]> q = new LinkedList<>();
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[][] cost = new int[grid.length][grid[0].length];
        // int[][] cost = new int[m][n];
        for (int[] row : cost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        cost[0][0] = 0;
        q.add(new int[] { 0, 0, 0 });
        while (!q.isEmpty()) {
            int[] element = q.remove();
            int x = element[0];
            int y = element[1];
            int currentCost = element[2];
            if (x == a - 1 && y == b - 1) {
                return currentCost;
            }
            for (int i = 0; i < 4; i++) {
                int m = dir[i][0] + x;
                int n = dir[i][1] + y;
                if (m >= 0 && m < grid.length && n >= 0 && n < grid[0].length) {
                    int newCost = currentCost + (grid[x][y] == i + 1 ? 0 : 1);
                    if (newCost < cost[m][n]) {
                        cost[m][n] = newCost;
                        if (grid[x][y] == i + 1) {
                            q.offerFirst(new int[] { m, n, newCost });

                        } else {
                            q.offerLast(new int[] { m, n, newCost });
                        }

                    }

                }

            }

        }

        return -1;
    }
}