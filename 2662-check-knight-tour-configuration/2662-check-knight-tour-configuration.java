class Solution {

    private final int[][] directions = new int[][] { { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 } , { 2, 1 }, { 2, -1 }, { -2, -1 }, { -2, 1 }};

    public boolean checkValidGrid(int[][] grid) {
        int start = 0, finish = grid.length * grid[0].length - 1;
        return dfs(grid, 0, 0, start - 1, finish);
    }

    private boolean dfs(int[][] grid, int row, int column, int previous, int finish) {
        boolean outside = row < 0 || row >= grid.length || column < 0 || column >= grid[0].length;
        if (outside || previous + 1 != grid[row][column])
            return false;

        if (grid[row][column] == finish)
            return true;

        for (int[] direction : directions) {
            if (dfs(grid, row + direction[0], column + direction[1], grid[row][column], finish))
                return true;
        }
        return false;
    }
}