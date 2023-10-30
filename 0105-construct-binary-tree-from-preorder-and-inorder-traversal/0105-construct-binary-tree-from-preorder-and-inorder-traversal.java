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
      Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
      
        for(int i = 0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
       return helper(preorder, inorder, 0, inorder.length - 1, 0, preorder.length - 1);
    }
    TreeNode helper(int[] preorder, int[] inorder, int inStart, int inEnd, 
                    int preStart, int preEnd){
        if(inStart > inEnd || preStart > preEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        //System.out.println(root.val);
        int mid = map.get(root.val);
//         root.left = helper(preorder, inorder, inStart, mid - 1, preStart + 1, mid - 1);
//         root.right = helper(preorder, inorder, mid + 1, inEnd , mid + 1, preEnd);
        
        root.left = helper(preorder, inorder, inStart, mid - 1, preStart + 1, preStart + mid - inStart);
        root.right = helper(preorder, inorder, mid + 1, inEnd , preStart + mid - inStart + 1, preEnd);

        return root;
    }
}