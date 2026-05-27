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

    Just traverse each side of the tree DFS style. You can do both sides in parallel. 

    On the recursive call, simply swap the node.left and node.right. 

    For example if comparing two trees, you would do:
    compare(TreeNode node1, TreeNode node2) {
        return compare(node1.left, node2.left) && compare(node1.right, node2.right);
    }

    When comparing mirrored trees, you instead do:
        compare(TreeNode node1, TreeNode node2) {
        return compare(node1.left, node2.right) && compare(node1.right, node2.left);
    }

    Of course, you also need to compare the values. 

    There are two base cases. 
    1. Both nodes are null (we cannot traverse any further, return true)
    2. One of the nodes is null (this means the nodes are not equal, return false)
    
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return traverse(root.left, root.right);
    }

    public boolean traverse(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return (node1.val == node2.val) && traverse(node1.left, node2.right) && traverse(node1.right, node2.left);
    }
}