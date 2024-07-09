class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList();
        if(heights.length == 0 || heights[0].length == 0)
            return result;

        int rowLength = heights.length;
        int colLength = heights[0].length;
        boolean[][] pacific = new boolean[rowLength][colLength];
        boolean[][] altantic = new boolean[rowLength][colLength];
        for(int col = 0; col <colLength; col++) {
            helper(heights, 0, col, heights[0][col], pacific); //top
            helper(heights, rowLength - 1, col, heights[rowLength - 1][col], altantic);//bottom
        }
        for(int row = 0; row < rowLength; row++) {
            helper(heights, row, 0, heights[row][0], pacific); //top
            helper(heights,row , colLength - 1, heights[row][colLength - 1], altantic);//bottom
        }
         for(int r=0; r<rowLength; r++) {
            for(int c=0; c<colLength; c++) {
                if(pacific[r][c] && altantic[r][c]) {
                    List<Integer> li = new ArrayList();
                    li.add(r);
                    li.add(c);
                    result.add(li);
                }
            }
        }
        return result;
    }
    
    void helper(int[][] heights, int row, int col, int previousHeight, boolean[][] visited) {
        if(row < 0 || row >= heights.length || col <0 || col >= heights[0].length || visited[row][col] || previousHeight > heights[row][col]) {
            return;
        }
        visited[row][col] = true;
        helper(heights, row, col + 1, heights[row][col], visited);
        helper(heights, row + 1, col, heights[row][col], visited);
        helper(heights, row, col - 1, heights[row][col], visited);
        helper(heights, row - 1, col, heights[row][col], visited);
    }
}