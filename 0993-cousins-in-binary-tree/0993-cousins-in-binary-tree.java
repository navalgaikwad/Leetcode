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
    int parentOfX = 0;
    int parentOfY = 0;
    int levelOfX = 0;
    int levelOfY = 0;
    class Pair {
        TreeNode node;
        int level;
        int prev;
        Pair(TreeNode node, int level, int prev) {
            this.node = node;
            this.level = level;
            this.prev = prev;
        }
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        helper(root, 0, x, y, 0);
        if(parentOfX != parentOfY && levelOfX == levelOfY) {
            return true;
        }
        return false;
    }
 /*   
    void helper(TreeNode root, int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0, 0));
        while(!q.isEmpty()) {
            Pair pair = q.remove();
            TreeNode current = pair.node;//2
            int level = pair.level;//1
            int prev = pair.prev;//1
            if( current.val == x) {
                parentOfX = prev; //2
                levelOfX = level;//2
            }
            if(current.val == y) {
                parentOfY = prev;//1
                levelOfY = level;//1
            }
            if(current.left != null) {
                q.add(new Pair(current.left, level+1, current.val));//2, 1, 1, [4, 2, 2]
            }
            if(current.right != null) {
                q.add(new Pair(current.right, level+1, current.val));//3, 1, 1
            }
        }
    }
    */
    
    void helper(TreeNode root, int level, int x, int y, int parent) {
        if( root == null) {
            return;
        }
        if(root.val == x) {
           parentOfX = parent;
           levelOfX = level;
        }
        if(root.val == y) {
           parentOfY = parent;
           levelOfY = level;
        }
        helper(root.left, level + 1, x, y, root.val);
        helper(root.right, level + 1, x, y, root.val);
    }
    
}
// cousin when they have same dept with diferent parent
//find the node with dept
//
//1
/*
parent1 = 0,1
level1 = 1
parent2 = 0, 2
level2 = 2

return false
return true
parent2 = null,

prev1:null, 1, 2
prev2:null, 1
{1, 0}
{2, 1}
{3, 1}
{4, 2}








*/