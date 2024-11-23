class Solution {

    int path[][];
    int mod=(int)Math.pow(10,9)+7;

    public int countPaths(int[][] grid) {
        
        int n=grid.length;
       int m=grid[0].length;

    int ans=0;
    path=new int[n][m];
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
           
            ans=(ans%mod+ dfs(grid,i,j,m,n,-1)%mod)%mod;
            
        }
    }
    return ans;
}
public int dfs(int[][] grid,int x,int y,int m,int n,int pre){
    if(x<0 || y<0 || x>=n || y>=m)return 0;
    if(grid[x][y]<=pre)return 0;
    if(path[x][y]!=0)return path[x][y];
   
    int l1=dfs(grid,x+1,y,m,n,grid[x][y]);
    int l2=dfs(grid,x-1,y,m,n,grid[x][y]);
    int l3=dfs(grid,x,y+1,m,n,grid[x][y]);
    int l4=dfs(grid,x,y-1,m,n,grid[x][y]);
    
    return  path[x][y]=(1+l1+l2+l3+l4)%mod;
    }
}