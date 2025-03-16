class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //for(int i =0; i<image.length; i++) {
            //for(int j=0; j<image[0].length; j++) {
                dfs(image, sr,sc, color, image[sr][sc]);
           // }
      //  }
        return image;
    }
    
    void dfs(int[][] image, int i, int j, int color, int curr) {
        if(i>=image.length || i<0 || j>=image[0].length || j<0 || image[i][j]==color
          || image[i][j]!=curr) { // image[i][j]!=curr 1 !2
            return;
        }
        image[i][j] = color;
        dfs(image, i+1, j, color, curr);
        dfs(image, i, j+1, color, curr);
        dfs(image, i, j-1, color, curr);
        dfs(image, i-1, j, color, curr);
        
    }
}