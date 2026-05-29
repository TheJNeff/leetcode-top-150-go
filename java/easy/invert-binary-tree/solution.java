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
 // This seems a bit like comparing 2 trees. If we can iterate over both subtrees at the same time, we can swap their values. I'm assuming we don't need to actually re-arrange the nodes, and just swapping the values will suffice. 

 As it turns out, it will not suffice. There's something I missed. If we have this tree:

 [1, 2]

    (1)
   /
 (2)

 Then when we change it to

     (1)
        \
        (2)

We should end up with [1, null, 2] apparently. 

Since we are returning the root, which holds the entire tree structure, we actually will need to change the structure to accomplish this. Swapping the values will not be good enough. 

So how does it change? Well, I think instead of looking at the current nodes in the recursive function, we should look at their children. That way we can add new nodes to the tree and delete existing ones. 

Yep. Works like a charm. 
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        invertTree(root.left);
        invertTree(root.right);

        TreeNode temp = new TreeNode();
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

    // first attempt. Ended up not working because it just swapped values and didn't alter the tree structure. 
    public void invert(TreeNode p, TreeNode q) {
        if (p == null && q == null) return;
        if (q == null) {
            q = new TreeNode();
            q.val = p.val;
            p = null;
            return;
        }
        invert(p.left, q.right);
        invert(p.right, q.left);

        int temp = 0;
        temp = p.val;
        p.val = q.val;
        q.val = temp;
    }
}