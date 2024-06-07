class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        return dfs(root, key);
    }
    TreeNode dfs(TreeNode root, int key) {
        if(root == null) {
            return null;
        }
        if(root.val > key) {
            root.left = dfs(root.left, key);
        }else if(root.val < key){
            root.right = dfs(root.right, key);
        }else {
            if(root.left != null && root.right==null && root.val == key) {
                return root.left;
            }else if(root.left == null && root.right!=null && root.val == key) {
                return root.right;
            }else if(root.left == null && root.right==null && root.val == key) {
                return null;
            }else if(root.left != null && root.right!=null && root.val == key) {
                TreeNode temp = lastNode(root.right);
                root.val = temp.val;
                root.right = dfs(root.right, temp.val);
            }
        }
        return root;
    }
    
    TreeNode lastNode(TreeNode node) {
        while(node.left != null) {
            node = node.left;
        }
        return node;
    }
}