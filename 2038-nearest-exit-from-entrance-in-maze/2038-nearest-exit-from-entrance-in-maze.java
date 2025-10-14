class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        if (maze.length == 0 || maze[0].length == 0)
            return -1;

        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        queue.add(new int[] { entrance[0], entrance[1], 1 });
        maze[entrance[0]][entrance[1]] = '+';
        while (!queue.isEmpty()) {
            int[] current = queue.remove();
            int coordinateX = current[0];
            int coordinateY = current[1];
            int exit = current[2];

            for (int[] dir : dirs) {
                int coordinateI = dir[0] + coordinateX;
                int coordinateJ = dir[1] + coordinateY;
                if (coordinateI >= 0 && coordinateI < maze.length && coordinateJ >= 0 && coordinateJ < maze[0].length
                        && maze[coordinateI][coordinateJ] == '.') {
                    if (coordinateI == 0 || coordinateI == maze.length - 1 || coordinateJ == 0
                            || coordinateJ == maze[0].length - 1) {
                        return exit;
                    }
                    maze[coordinateI][coordinateJ] = '+';
                    queue.add(new int[] { coordinateI, coordinateJ, exit + 1 });
                }

            }
        }
        return -1;
    }
}