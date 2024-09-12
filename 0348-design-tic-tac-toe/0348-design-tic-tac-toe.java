class TicTacToe {
    HashMap<String, Integer> map = new HashMap<>();
    int n =0;
    
    public TicTacToe(int n) {
        this.n = n;
    }
    
    public int move(int row, int col, int player) {
        int[] dirs = {row, col, row - col, row + col};
        for(int i =0; i< 4; i++) {
            String key = i+"-"+dirs[i]+"-"+player;
            map.put(key, map.getOrDefault(key, 0) + 1);
            if(map.getOrDefault(key, 0) == n) {
                return player;
            }
           // map.put(key, map.getOrDefault(key, 0) + 1);
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */