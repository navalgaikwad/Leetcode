class Solution {
    public int findChampion(int[][] grid) {
        int winner = 0;
        for(int opponent = 1; opponent < grid[0].length; opponent++){
            if(opponent == winner){
                continue;
            }
            if(grid[winner][opponent] == 0){
                winner = opponent;
            }
        }
        return winner;
    }
}