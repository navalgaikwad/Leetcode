// import java.util.*;

// class Solution {
//     public int equalPairs(int[][] grid) {
//         Map<String, Integer> map = new HashMap<>();
//         for (int row = 0; row < grid.length; row++) {
//             StringBuilder value = new StringBuilder();
//             for (int col = 0; col < grid[0].length; col++) {
//                 value.append(grid[row][col]);
//             }
//             map.put(value.toString(), map.getOrDefault(value.toString(), 0) + 1);
//         }
        
//         int n = grid[0].length;
//         int count = 0;
//         for (int col = 0; col < n; col++) {
//             StringBuilder colValue = new StringBuilder();
//             for (int row = 0; row < n; row++) {
//                 colValue.append(grid[row][col]);
//             }
//             count += map.getOrDefault(colValue.toString(), 0);
//         }
        
//         return count;
//     }
// }
import java.util.HashMap;
import java.util.Map;
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
        System.out.print(rowCounter);
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
