class Solution {
    public int snakesAndLadders(int[][] board) {
        int m = board.length;
        int target = m * m;
        
        Integer[] column = new Integer[m];
        
        for(int i=0; i<m ;i++) {
            column[i] = i;
        }
        List<Integer> list = new ArrayList<>();
        int[][] cell = new int[m*m+1][2];
        int label = 1;
         for(int row = m-1; row>=0; row--) {
            for(Integer col : column) {
                cell[label][0] =row;
                cell[label][1] = col;
                label++;
            }
            Collections.reverse(Arrays.asList(column));
        }
        HashSet<Integer> visited = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0});
        
        while(!q.isEmpty()) {
            int[] current = q.remove();
            int nextPosition = current[0];
            int level = current[1];
            
            if(nextPosition == target) {
                return level;
            }
            for(int i=1; i<7; i++) {
                int next = i + nextPosition;
                if(next <= target) {
                    int nextRow = cell[next][0];
                    int nextCol = cell[next][1];
                    int destination = board[nextRow][nextCol] == -1 ? next : board[nextRow][nextCol] ;
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
