class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int target = n * n;
        Integer[] columns = new Integer[n];
        
        //most important 
        //first define columns array
        for(int i =0 ;i< n; i++) {
            columns[i] = i; // add the value in the columns
        }
        
        int label = 1;
        //n * n + 1 total element in the array
        Pair<Integer, Integer> cell[] = new Pair[n * n + 1];// use pair defined as Key value in array
        for(int row = n -1; row >=0; row--) {// start from the end so n -1
            for(int col : columns) { // start from first
                cell[label++] = new Pair<>(row, col); // at each level we will be giving marking
            }
            Collections.reverse(Arrays.asList(columns));// reverse it
        }
    
    Set<Integer> visited = new HashSet<>();
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{1, 0}); //start from one rather 0 it is given in the problem
    
    while(!q.isEmpty()) {
        int[] current = q.remove();
        int currentStep = current[0];
        int level = current[1];
        if(currentStep == target) {
            return level;
        }
        
        for (int i =1; i<7; i++) { //it will move 7 times 0 to 6
            int nextPosition = i + currentStep;
            if(nextPosition <= target) {
                int nextRow = cell[nextPosition].getKey(); // get the value form cell row 5
                int nextCol = cell[nextPosition].getValue();// col 0
                int destination = ( board[nextRow][nextCol] != -1 ) ? board[nextRow][nextCol] : nextPosition;
                
                  if(!visited.contains(destination)){
                         
                         visited.add( destination );
                         q.add(new int[]{ destination , level + 1 });
                         
                } 
            }
        }
    }
    return -1;
    }
}

// [[-1,-1,-1,-1,-1,-1],
//  [-1,-1,-1,-1,-1,-1],
//  [-1,-1,-1,-1,-1,-1],
//  [-1,35,-1,-1,13,-1],
//  [-1,-1,-1,-1,-1,-1],
//  [-1,15,-1,-1,-1,-1]]