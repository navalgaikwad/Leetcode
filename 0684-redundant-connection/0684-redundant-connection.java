class UnionFind {
    int[] root;
    int[] rank;
    
    UnionFind(int n){
        this.root=new int[n];
        this.rank=new int[n];
        for(int i=0;i<n;i++){
            root[i] = i;        
        }
    }
    
    int find(int x){
        if(x == root[x]){
            return x;
        }
        return root[x] = find(root[x]);
    }
    
    boolean union(int x, int y){
        int xHead = find(x);
        int yHead = find(y);
        if(xHead == yHead){
            return false;
        } else if(rank[xHead] < rank[yHead]){
             root[xHead] =yHead;
        }else{
               root[yHead] =xHead;
               rank[xHead]++;
               
        }
        return true;
        
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf =new UnionFind(edges.length+1);
        for(int[] edge: edges){
            
            if(!uf.union(edge[0], edge[1])){
                return edge;
            }
        }
        return new int[]{};
    }
}