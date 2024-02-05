class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        ArrayList<Integer> adj[] = new ArrayList[n];
        for(int i=0 ;i<n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i=0; i<n; i++) {
            //manager = [2,2,-1,2,2,2,4]
            if(manager[i] != -1) {
               adj[manager[i]].add(i); 
            }  
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{headID, 0});
        HashSet<Integer> visited = new HashSet<>();
        int maxTime = 0;
        while(!q.isEmpty()) {
            int[] current = q.remove();
            int x = current[0];
            int level = current[1];
            if(level >maxTime) {
                maxTime = level;
            }
            
            for(Integer neighbour :adj[x]) {
                if(!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    q.add(new int[]{neighbour, level+informTime[x]});
                }
            }
        }
        return maxTime;
    }
}

//7
//6
//[1,2,3,4,5,6,-1]
//[0,6,5,4,3,2,1]

//if i created adjelist 
// 0 - 2
// 1 - 2
// 2 - 2
// 3 - 2
// 4 - 2
// 5 - 2
//manager = [2,2,-1,2,2,2, 4]
// 2 - 0 , 1, 3, 4, 5, 6
// 4 - 7