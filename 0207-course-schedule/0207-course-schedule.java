class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> adj[] =new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] prerequisite:prerequisites){
             adj[prerequisite[1]].add(prerequisite[0]);
             indegree[prerequisite[0]]++;
            // indegree[prerequisite[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for( int i=0; i<numCourses; i++){
            if(indegree[i] == 0){
               q.add(i); 
            }
        }
        int count =0;
        while(!q.isEmpty()){
            int current = q.remove();
            System.out.print(current);
            count++;
            for(Integer neighbour:adj[current]){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                  q.add(neighbour);  
                }
            }
        }
        if(count == numCourses){
            return true;
        }
        return false;
    }
}