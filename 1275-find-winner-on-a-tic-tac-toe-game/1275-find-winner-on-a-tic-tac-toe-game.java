
class Solution {
    public String tictactoe(int[][] moves) {
        int n = 3;
        int[] rows = new int[n];
        int[] cols = new int[n];
        int d1 = 0, d2 = 0;
        int player = 1;
        
        for (int[] move : moves) {
            int r = move[0];
            int c = move[1];
            
            rows[r] += player;
            cols[c] += player;
            if (r == c) d1 += player;
            if (r + c == n - 1) d2 += player;
            
            if (Math.abs(rows[r]) == n || Math.abs(cols[c]) == n || Math.abs(d1) == n || Math.abs(d2) == n) {
                if (player == 1) {
                    return "A";
                } else {
                    return "B";
                }
            }
            
            player *= -1;
        }
        
        if (moves.length == n * n) {
            return "Draw";
        } else {
            return "Pending";
        }
    }
}
