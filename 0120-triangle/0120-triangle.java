class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //triangle
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[][] grid = new int[m][n];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < triangle.get(row).size(); col++) {
                grid[row][col] = triangle.get(row).get(col);
            }
            // Fill remaining cells in the row with a value indicating they are invalid.
            for (int col = triangle.get(row).size(); col < n; col++) {
                grid[row][col] = Integer.MAX_VALUE;
            }
        }
        m = grid.length -1 ;
        n = grid[0].length -1;
        
        int ans = Integer.MAX_VALUE;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < grid[m].length; i++){
            ans = Math.min(helper(grid, m, i, map), ans);
        }
        
        // System.out.print(helper(grid, m, n, new HashMap<>()));
        return ans;
    }
    
      int helper(int[][] grid, int i, int j, HashMap<String, Integer> memo){
        
        String key = i+"-"+j;
        if(memo.containsKey(key)){
           return memo.get(key); 
        }
         if( i < 0 || j < 0 || grid[i][j] == Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if( i == 0 && j == 0){
            return grid[i][j];
        }

        //int sum = ;
       
        int val2 =  helper(grid, i - 1, j - 1, memo); //daigonal
        int val1 =  helper(grid, i - 1, j, memo);//next line
        
        int result = Math.min(val1, val2) + grid[i][j];
       
        memo.put(key, result); 
        return result;
    }
}


