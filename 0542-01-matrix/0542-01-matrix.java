class Solution {
    boolean isValid(int[][] mat, int i, int j) {
        return i>=0&& i<mat.length&& j>=0&&j<mat[0].length;
    }
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Set<String> visited = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<m; i++) {
            for(int j =0; j<n; j++) {
                if(mat[i][j]==0) {
                    q.add(new int[]{i, j, 0});
                    visited.add(i+"-"+j);
                }
            }
        }
        return helper(visited, q, mat);
        
    }
    
    int[][] helper(Set<String> visited, Queue<int[]> q, int[][] mat) {
        int[][] dir = {{1,0}, {0, 1}, {-1, 0}, {0, -1}};
        while(!q.isEmpty()) {
            int[] current = q.remove();
            int i = current[0];
            int j = current[1];
            int len = current[2];
            if(mat[i][j]!=0) {
              mat[i][j] = len;  
            }
            for(int[] di : dir) {
                int xDir = di[0] + i;
                int yDir = di[1] + j;
                if(isValid(mat, xDir, yDir) && !visited.contains(xDir+"-"+yDir)) {
                    q.add(new int[]{xDir, yDir, len+1});
                    visited.add(xDir+"-"+yDir);
                }
            }
        }
        return mat;
    }
    
}