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

    public void flatten(TreeNode root) {
        flattenHelper(root);
    }

    public TreeNode flattenHelper(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        if (root.left == null) {
            root.right = flattenHelper(root.right);
        } else {
            
            TreeNode temp = flattenHelper(root.right);
            root.right = flattenHelper(root.left);
            TreeNode itr = root.right;
            while (itr.right != null) {
                itr = itr.right;
            }
            itr.right = temp;
            root.left = null;
        }
        return root;
    }
}