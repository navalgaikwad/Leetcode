class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] viisted = new boolean[rooms.size()];
        helper(rooms, 0, viisted);
        for(boolean viist : viisted) {
            if(!viist) return false; 
        }
        return true;
    }
    
    void helper(List<List<Integer>> rooms, int start, boolean[] visited) {
        visited[start] = true;
        for(Integer neighbour: rooms.get(start)) {
            if(!visited[neighbour]) {
                helper(rooms, neighbour, visited);
            }
        }
    }
}