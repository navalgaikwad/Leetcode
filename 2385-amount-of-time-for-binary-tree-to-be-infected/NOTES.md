class Solution {
Map<Integer, ArrayList<Integer>> map = new HashMap<>();
void buildList(TreeNode child, TreeNode parent) {
if(child == null) {
return;
}
//child nasel tar map madhye tar tak
if(!map.containsKey(child.val)) {
map.put(child.val, new ArrayList<>());
}//parent null nasel tar child and parent val takla ahe
if(parent != null) {
map.get(parent.val).add(child.val);
map.get(child.val).add(parent.val);
}
buildList(child.left, child);
buildList(child.right, child);
}
public int amountOfTime(TreeNode root, int start) {
buildList(root, null);
Queue<int[]> q = new LinkedList<>();
q.add(new int[]{start, 0});
HashSet<Integer>visited = new HashSet<>();
visited.add(start);
int max = 0;
int[] dist = new int[map.size()];
//dist[start] = 0;
while(!q.isEmpty()) {
int[] current = q.remove();
int i = current[0];
int level = current[1];
max = Math.max(max, level);
for(Integer neighbour: map.get(i)) {
if(!visited.contains(neighbour)) {
//dist[neighbour] = dist[i] + 1;
visited.add(neighbour);
q.add(new int[]{neighbour, level+1});
}
}
}
// for(int d : dist) {
//     System.out.print(d);
// }
return max;
}
}