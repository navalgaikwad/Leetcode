class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        ArrayList<Integer> adj[] = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                adj[manager[i]].add(i);
            }
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{headID, 0});
        int maxTime = 0;
        HashSet<Integer> visited = new HashSet<>();

        while (!q.isEmpty()) {
            int[] current = q.remove();
            int x = current[0];
            int level = current[1];
            if (level > maxTime) {
                maxTime = level;
            }

            for (Integer neighbour : adj[x]) {
                    q.add(new int[]{neighbour, level + informTime[x]});
                }
            }
        return maxTime;
    }
}
