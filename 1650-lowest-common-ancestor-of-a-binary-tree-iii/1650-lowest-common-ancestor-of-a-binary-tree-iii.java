/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Integer> set = new HashSet<>();
        while(p!=null) {
            set.add(p.val);
            p = p.parent;
        }
        while(q!=null) {
            if(set.contains(q.val)) {
                return q;
            }
            q = q.parent;
        }
        return null;
    }
}