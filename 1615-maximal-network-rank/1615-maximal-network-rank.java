class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] degree = new int[n];
        boolean connected[][] = new boolean[n][n];
        for(int road[]:roads){
            degree[road[0]]++;//
            degree[road[1]]++;
            connected[road[0]][road[1]] =true;
            connected[road[1]][road[0]]=true;
        }
        int result = 0;
        for(int i =0; i< n; i++) {
            for(int j = i + 1; j<n; j++) { // to avoid duplicate 
                int sum = degree[i] + degree[j] - (connected[i][j]?1:0);
                result = Math.max(result, sum);
            }
        }
        return result;
        
    }
}
