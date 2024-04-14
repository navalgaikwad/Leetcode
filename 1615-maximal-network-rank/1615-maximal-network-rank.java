class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] connections = new int[n];
        boolean[][] graph = new boolean[n][n];

        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            connections[a]++;
            connections[b]++;
            graph[a][b] = graph[b][a] = true;
        }

        int maxRank = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int rank = connections[i] + connections[j];
                if (graph[i][j]) {
                    rank--;
                }
                maxRank = Math.max(maxRank, rank);
            }
        }

        return maxRank;
    }
}
