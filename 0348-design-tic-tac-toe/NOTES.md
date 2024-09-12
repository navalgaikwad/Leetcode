class TicTacToe {
HashMap<String, Integer> map = new HashMap<>();
int limit;
public TicTacToe(int n) {
limit = n;
}
public int move(int row, int col, int player) {
int[] dirs = {row, col, row + col, row - col};
for(int i=0; i<4; i++) {
String value = i+"-"+dirs[i]+"-"+player;
map.put(value, map.getOrDefault(value, 0) + 1);
if(map.get(value) == limit) {
return player;
}
}
return 0;
}
}
​
/**
* Your TicTacToe object will be instantiated and called as such:
* TicTacToe obj = new TicTacToe(n);
* int param_1 = obj.move(row,col,player);
*/