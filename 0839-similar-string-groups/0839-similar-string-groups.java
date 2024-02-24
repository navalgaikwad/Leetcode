class Solution {
    public int numSimilarGroups(String[] strs) {
        int group =0;
        boolean[] visited = new boolean[strs.length];
        for(int i=0; i<strs.length; i++) {
            if(!visited[i]) {
                dfs(strs, i, visited);
                group++;
            }
        }
        return group;
    }
    
    void dfs(String[] strs, int parent, boolean[] visited) {
        visited[parent] = true;
        for(int i=0; i<strs.length; i++) {
            //important is here check parent with all string
            if(!visited[i] && check(strs[i], strs[parent])) {
                dfs(strs, i, visited);
            }
        }
    }
    
    boolean check(String a, String b) {
        int i = 0; 
        int j = 0;
        int count =0;
        while(i < a.length() && j < b.length()) {
            if(a.charAt(i)!=b.charAt(j)) {
                count++;
            }
            i++;
            j++;
        }
        return count==0 || count==2;
    }
}

//["tars","rats","arts","star"]
//