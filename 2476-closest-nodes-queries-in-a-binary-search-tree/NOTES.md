/**
* Definition for a binary tree node.
* public class TreeNode {
*     int val;
*     TreeNode left;
*     TreeNode right;
*     TreeNode() {}
*     TreeNode(int val) { this.val = val; }
*     TreeNode(int val, TreeNode left, TreeNode right) {
*         this.val = val;
*         this.left = left;
*         this.right = right;
*     }
* }
*/
class Solution {
public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
TreeSet<Integer> set = new TreeSet<>();
goDFS(root, set);
List<List<Integer>> res = new ArrayList<>(queries.size());
for (int q : queries) {
List<Integer> l = new ArrayList<>();
Integer min = set.floor(q);//backward,
Integer max = set.ceiling(q);//forward
min = min == null ? -1 : min;
max = max == null ? -1 : max;
l.add(min);
l.add(max);
res.add(l);
}
return res;
}
​
private void goDFS(TreeNode node, TreeSet<Integer> set) {
if (node == null) return;
​
set.add(node.val);
​
goDFS(node.left, set);
goDFS(node.right, set);
}
}