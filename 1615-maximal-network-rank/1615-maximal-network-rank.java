import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        Set<String> roadSet = new HashSet<>();
        int[] degrees = new int[n];
        
        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            roadSet.add(a + "-" + b);
            roadSet.add(b + "-" + a);
            degrees[a]++;
            degrees[b]++;
        }

        int rank = 0;
        for (int a = 0; a < n; a++) {
            for (int b = a + 1; b < n; b++) {
                int currRank = degrees[a] + degrees[b];
                if (roadSet.contains(a + "-" + b)) {
                    currRank--;
                }
                rank = Math.max(rank, currRank);
            }
        }

        return rank;
    }
}
