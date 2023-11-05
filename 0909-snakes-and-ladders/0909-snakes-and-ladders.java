class Solution {
    
    class Vertex implements Comparable<Vertex>{
        int distance, label;
        Vertex(int distance, int label){
            this.distance = distance;
            this.label = label;
        }
        public int compareTo(Vertex v){ //used compareTo sort by distances
            return this.distance - v.distance;
        }
    }
    
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Pair<Integer, Integer>[] cells = new Pair[n * n + 1];
        int label = 1;
        Integer[] columns = new Integer[n];
        for(int i = 0; i<n; i++){
            columns[i] = i;
        }
        // 
        for(int row = n - 1; row>=0;row--){
            for(int column : columns){
                //given label to all row  and col
              //  System.out.print(label+" label"+ "  "+ row +" row " + column+" ");
                cells[label++] = new Pair<>(row, column);
            }
            Collections.reverse(Arrays.asList(columns));
           // System.out.println("\n");
        }
        int[] dist = new int[n * n + 1];
        Arrays.fill(dist, -1);
        
        PriorityQueue<Vertex> q = new PriorityQueue<Vertex>();
        dist[1] = 0; 
        q.add(new Vertex(0, 1));
        while(!q.isEmpty()){
            Vertex v = q.remove();
            int currdistance = v.distance;
            int currLabel = v.label;
            
            if(currdistance != dist[currLabel]){
               continue;   
            }
            for(int next = currLabel + 1; next <= Math.min(currLabel + 6, n*n); next++){
                int row = cells[next].getKey();
                int col = cells[next].getValue();
                //need to check for row and col have -1
                //need t somthing to go next postion
                int destination = board[row][col]!=-1 ? board[row][col]: next;
                //if it is -1 one dont consider
                //what to do if it is -1 or dist[currLabel] + 1 < dist[destination]
                //when you are that row and col 1. go to next update the current distance
                if(dist[destination] == -1 || dist[currLabel] + 1 < dist[destination]){
                    dist[destination] = dist[currLabel] + 1;
                    q.add(new Vertex(dist[destination], destination));
                }
            }
        }
        return dist[n * n];
    }
}