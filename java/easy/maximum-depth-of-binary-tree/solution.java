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

 This seems fairly easy. All we need to do is traverse the tree. We can do with with BFS or DFS. 

 Whether it's a pre-order (roots before leaves). post-order (leaves before roots), or in-order (binary search tree order, left to right) traversal doesn't matter. 

 I'd prefer to use DFS for this because it is quite simple to write and it will make tracking the depth easier. 

 Nice, this recursive DFS is simple and fast. 
 */
class Solution {
    int depth = 0;
    public int maxDepth(TreeNode root) {
        if (root != null) {
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        } else {
            return 0;
        }
    }
}