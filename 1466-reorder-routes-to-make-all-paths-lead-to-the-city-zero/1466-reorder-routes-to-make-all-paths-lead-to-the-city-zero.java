class Solution {
	class Pair{
		int dest;
		int color;
		Pair(int dest, int color){
			this.dest=dest;
			this.color=color;
		}
	}
    int count =0;
    public int minReorder(int n, int[][] connections) {
	ArrayList<Pair> adj[] =new ArrayList[n];
		for(int i=0; i<n; i++){
				adj[i] = new ArrayList<>();
		}
		for(int[] connection: connections){
			adj[connection[0]].add(new Pair(connection[1], 1));
			adj[connection[1]].add(new Pair(connection[0], 0));
            
       System.out.println(connection[0] +" "+ connection[1]);
       System.out.println(connection[1] +" "+ connection[0]);
            
		}
   
	dfs(adj, 0, -1);
    return count;
	}
	
	void dfs(ArrayList<Pair> adj[], int src, int parent){
		for(Pair pair: adj[src]){
			if(pair.dest!=parent){
                System.out.println(parent + " "+src+"-"+pair.dest +" - "+pair.color);
				count+=pair.color;
				dfs(adj, pair.dest, src);
			}
		}
	}
}