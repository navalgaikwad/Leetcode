
class Solution {
    public int equalPairs(int[][] grid) {
        int count = 0;
        int n = grid.length;

        // Keep track of the frequency of each row.
        Map<String, Integer> rowCounter = new HashMap<>();
        for (int[] row : grid) 
        {
            String rowString = Arrays.toString(row);
            rowCounter.put(rowString,  rowCounter.getOrDefault(rowString, 0) + 1);
        }
       // System.out.print(rowCounter);
        // Add up the frequency of each column in the map.
        for (int c = 0; c < n; c++) 
        {
            int[] colArray = new int[n];
            for (int r = 0; r < n; r++) 
            {
                colArray[r] = grid[r][c];
            }
            count += rowCounter.getOrDefault(Arrays.toString(colArray), 0);
        }

        return count;
    }
}