class Solution {
    public int[][] updateMatrix(int[][] mat) {
        //put all zeros
        //then traverse all zeros
        //whenever i find one update with len
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[0].length; j++) {
                if(mat[i][j] == 0) {
                    q.add(new int[]{i, j, 0});
                }
            }
        }
        return helper(q, mat);
    }
    
    int[][] helper(Queue<int[]> q, int[][] mat) {
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        HashSet<String> visited = new HashSet<>();
        while(!q.isEmpty()) {
            int[] current = q.remove();
            int i = current[0];
            int j = current[1];
            int level = current[2];
            if(mat[i][j] != 0) {
                mat[i][j] = level;
            }
            
            for(int[] dir: dirs) {
                int x = dir[0] + i;
                int y = dir[1] + j;
                
                if(x>=0 && x<mat.length && y>=0 && y<mat[0].length && !visited.contains(x+"-"+y)) {
                    visited.add(x+"-"+y);
                    q.add(new int[]{x, y, level+1});
                }
            }
        }
        return mat;
    }
}