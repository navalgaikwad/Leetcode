class Solution {
    public int snakesAndLadders(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        Integer[] column = new Integer[m];
        int target = m*m;
        for(int i=0;i<m;i++) {
            column[i] = i;
        }
        
        int[][] cell = new int[m*m+1][2];
        int label = 1;
        for(int row = m-1; row>=0; row--) {
            for(int col: column) {
                cell[label][0] = row;
                cell[label][1] = col;
                label++;
            }
            Collections.reverse(Arrays.asList(column));
        }
        
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1,0});
        while(!q.isEmpty()) {
            int[] current = q.remove();
            int currentStep = current[0];
            int level = current[1];
            if(currentStep == target) {
                return level;
            }
            for(int i =1; i<7; i++) {
                int nextPosition = i+currentStep;
                if(nextPosition <= target) {
                    int nextRow = cell[nextPosition][0];
                    int nextCol = cell[nextPosition][1];
                    int destination = board[nextRow][nextCol] == -1 ? nextPosition : board[nextRow][nextCol];
                    if(!visited.contains(destination)) {
                        visited.add(destination);
                        q.add(new int[]{destination, level+1});
                    }
                }
            }
        }
        return -1;
    }
}