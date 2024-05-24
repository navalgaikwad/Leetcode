class Solution {
public int nearestExit(char[][] grid, int[] entrance) {
if (grid.length == 0 || grid[0].length == 0)
return-1;

    int n = grid.length, m = grid[0].length;
    LinkedList<int[]> que = new LinkedList<>();
    int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    int startrow =entrance[0];
    int startcol = entrance[1];
    que.addLast(entrance);
    grid[startrow][startcol] = '+';
    int level=0;
    while (que.size() != 0) {
        int size = que.size();
        level++;
        while (size-- > 0) {
            
            int[] idx = que.removeFirst();
            int sr = idx[0], sc = idx[1];

            for (int d = 0; d < dir.length; d++) {
                int r = sr + dir[d][0];
                int c = sc + dir[d][1];

                if (r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == '.') {
                    if(r==0 || r== n-1 || c==0 ||c==m-1) return level;
                    grid[r][c]='+';
                    que.addLast(new int[]{r, c});
                }
            }
        }
    
    
}
    return -1;
}
}