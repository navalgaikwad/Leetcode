class Solution {
    public boolean isPathCrossing(String path) {
        int x = 0, y = 0;
        Set<String> visited = new HashSet<String>();
        visited.add(x+","+y);
        for(int i = 0; i < path.length(); i++){
            if(path.charAt(i) == 'N'){
                y++;
            }
            else if(path.charAt(i) == 'S'){
                y--;
            }
            else if(path.charAt(i) == 'E'){
                x++;
            }
            else if(path.charAt(i) == 'W'){
                x--;
            }
            String temp = x + "," + y;
            if(visited.contains(temp)){
                return true;
            }
            else{
                visited.add(temp);
            }
        }
        return false;
    }
}