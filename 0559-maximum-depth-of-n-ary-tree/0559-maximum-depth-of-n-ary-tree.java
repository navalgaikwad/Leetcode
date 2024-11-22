/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    int ans =0;
    public int maxDepth(Node root) {
        dept(root, 1);
        return ans;
    }
    
    void dept(Node root, int level) {
        if(root == null) return;
        if(level > ans) {
            ans = level;
        }
        for(Node neighbo : root.children) {
            dept(neighbo, level + 1);
        }
    }
}