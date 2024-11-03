class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms, 0, visited);
        for(boolean visit: visited) {
            if(!visit) {
                return false;
            }
        }
        return true;
    }
    
    void dfs(List<List<Integer>> rooms, int parent, boolean[] visited) {
        visited[parent] = true;
        for(Integer neighbour :rooms.get(parent)) {
            if(!visited[neighbour]) {
                dfs(rooms, neighbour, visited);
            }
        }
    }
}