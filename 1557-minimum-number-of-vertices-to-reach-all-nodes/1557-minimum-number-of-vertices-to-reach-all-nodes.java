class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] indirect = new int[n];
        for(List<Integer> edge: edges) {
           // indirect[edge.get(0)]++;
            indirect[edge.get(1)]++;
        }
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<indirect.length; i++) {
            if(indirect[i] == 0) {
                result.add(i);
            }
        }
        return result;
    }
}