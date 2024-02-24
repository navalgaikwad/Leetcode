class Solution {
public int numSimilarGroups(String[] strs) {
int group=0;
boolean[] visited=new boolean[strs.length];
for(int i=0; i<strs.length; i++){
if(visited[i]){
continue;
}
dfs(strs, i, visited);
group++;
}
return  group;
}
​
void dfs(String[] strs, int parent, boolean[] visited) {
visited[parent]= true;
for(int i=0; i<strs.length; i++) {
if(!visited[i] && check(strs[i], strs[parent])) {
dfs(strs, i, visited);
}
}
}
​
​
boolean check(String a,  String b) {
int i=0;
int count =0;
while(i < a.length()) {
if(a.charAt(i)!=b.charAt(i)) {
count++;
}
i++;
}
return count==2 || count==0;
}
}