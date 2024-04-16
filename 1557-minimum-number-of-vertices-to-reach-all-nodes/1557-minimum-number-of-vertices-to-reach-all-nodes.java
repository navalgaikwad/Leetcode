class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int len = edges.size();
        int[] indegree = new int[n];
        for(List<Integer> edge : edges) {
            indegree[edge.get(1)]++;
        }
        List<Integer> answer = new ArrayList<>();
        for( int i =0; i< n;i++){
            if(indegree[i] == 0) {
               answer.add(i); 
            }
        }
        return answer;
    }
}