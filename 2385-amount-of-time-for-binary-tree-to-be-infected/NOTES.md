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