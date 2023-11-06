private void buildAdjList(TreeNode node, TreeNode parent) {
if (node == null) {
return;
}
//check value is present in map
if (!adjListMap.containsKey(node.val)) {
adjListMap.put(node.val, new ArrayList<>());
}
// If the current node is not the root (i.e., it has a parent), add an edge from the parent to the current node.
if (parent != null) {
adjListMap.get(parent.val).add(node.val);
}
// Recursively build adjacency list for the left subtree.
buildAdjList(node.left, node);
// Recursively build adjacency list for the right subtree.
buildAdjList(node.right, node);
}